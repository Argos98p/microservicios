package com.turisup.rdfservice.repository;

import com.complexible.stardog.api.Connection;
import com.complexible.stardog.jena.SDJenaFactory;
import com.turisup.rdfservice.Stardog.SparqlQueries;
import com.turisup.rdfservice.Stardog.StardogConnection;
import com.turisup.rdfservice.model.CommentBasic;
import com.turisup.rdfservice.model.Place;
import com.turisup.rdfservice.model.QueryOptions;
import com.turisup.rdfservice.utils.Parser;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlaceRepository  {
    String uriBase = "http://turis-ucuenca";
    public Optional<Place> getById(String idUri, double lat, double lng){
        try(Connection myConnection = StardogConnection.createConnection()){
            Model myModel = SDJenaFactory.createModel(myConnection);
            Place myNewPlace=new Place();
            if(myModel.containsResource(myModel.getResource(uriBase+"/lugar/"+idUri))){
                String queryString = SparqlQueries.getRecursoById(idUri, "3");
                Query query = QueryFactory.create(queryString);
                QueryExecution qexec = QueryExecutionFactory.create(query,myModel);
                try {
                    ResultSet results= qexec.execSelect();
                    while(results.hasNext()){
                        QuerySolution soln = results.nextSolution();
                        myNewPlace= Parser.RdfPlaceToObjectPlace(soln);
                        myNewPlace.setId(idUri);
                    }
                }finally {
                    qexec.close();
                }
                return Optional.of(myNewPlace);
            }else{
                return Optional.empty();
            }


        }




    }

    public Optional<List<Place>> getAll(String regionId) {

        try(Connection myConnection = StardogConnection.createConnection()){
            Model myModel = SDJenaFactory.createModel(myConnection);
            List<Place> places = new ArrayList<>();

            QueryOptions queryOptions = new QueryOptions();

                if(regionId!=null){
                    if(myModel.containsResource(myModel.getResource(uriBase+"/region/"+regionId))  ){
                        queryOptions.setRegionId(regionId);
                    }else {
                        return Optional.empty();
                    }

                }

                String queryString = SparqlQueries.defaultQuery(queryOptions);
                Query query = QueryFactory.create(queryString);
                QueryExecution qexec = QueryExecutionFactory.create(query,myModel);
                try {
                    ResultSet results= qexec.execSelect();
                    while(results.hasNext()){
                        QuerySolution soln = results.nextSolution();
                        Place placeResponse = Parser.RdfPlaceToObjectPlace(soln);

                        if(placeResponse!=null){
                            places.add(placeResponse);
                        }
                    }
                }finally {
                    qexec.close();
                }
                return Optional.of(places);

        }
    }

    public Optional<List<CommentBasic>> getCommentsForAdmin(String placeId){
        try(Connection myConnection = StardogConnection.createConnection()){
            Model myModel = SDJenaFactory.createModel(myConnection);
            List<CommentBasic> comentarios = new ArrayList<>();

            QueryOptions queryOptions = new QueryOptions();

            if(myModel.containsResource(myModel.getResource(uriBase+"/lugar/"+placeId))){
                String queryString = SparqlQueries.getComentsForAdmin(placeId);
                Query query = QueryFactory.create(queryString);
                QueryExecution qexec = QueryExecutionFactory.create(query,myModel);
                try {
                    ResultSet results= qexec.execSelect();
                    while(results.hasNext()){
                        QuerySolution soln = results.nextSolution();
                        CommentBasic commentBasic= Parser.RdfCommentToObjectComment(soln);
                        comentarios.add(commentBasic);
                    }
                }finally {
                    qexec.close();
                }
                return Optional.of(comentarios);
            }else{
                return Optional.empty();
            }




        }
    }
}
