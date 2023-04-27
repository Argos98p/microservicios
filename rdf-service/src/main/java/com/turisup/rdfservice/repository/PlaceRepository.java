package com.turisup.rdfservice.repository;

import com.complexible.stardog.api.Connection;
import com.complexible.stardog.jena.SDJenaFactory;
import com.turisup.rdfservice.Stardog.SparqlQueries;
import com.turisup.rdfservice.Stardog.StardogConnection;
import com.turisup.rdfservice.model.Place;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlaceRepository  {
    String uriBase = "http://turis-ucuenca/lugar/";
    public Optional<Place> getById(String idUri, double lat, double lng){
        try(Connection myConnection = StardogConnection.createConnection()){
            Model myModel = SDJenaFactory.createModel(myConnection);

            if(myModel.containsResource(myModel.getResource("http://turis-ucuenca/lugar/"+idUri))){
                String queryString = SparqlQueries.getRecursoById(idUri, "3");
                Query query = QueryFactory.create(queryString);
                QueryExecution qexec = QueryExecutionFactory.create(query,myModel);
                try {

                }finally {
                    qexec.close();
                }
            }else{

            }







        }




    }

}
