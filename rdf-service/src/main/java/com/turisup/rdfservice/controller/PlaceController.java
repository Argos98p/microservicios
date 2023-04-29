package com.turisup.rdfservice.controller;

import com.turisup.rdfservice.model.CommentBasic;
import com.turisup.rdfservice.model.Place;
import com.turisup.rdfservice.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/place/{id}")
    public ResponseEntity<?> placeById(@PathVariable(value = "id") String uriId) {
        Optional<Place> optionalPlace = placeRepository.getById(uriId, 0.0,0.0);
        return (optionalPlace.isPresent() 
                ? ResponseEntity.ok(optionalPlace.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("El lugar "+uriId+" no existe"));
    }

    @GetMapping("/places")
    public ResponseEntity<?> allPlaces(@RequestParam (name="regionId",required=false)  String regionId){
        Optional<List<Place>> optionalPlaces = placeRepository.getAll(regionId);
        return (optionalPlaces.isPresent()
                ? ResponseEntity.ok(optionalPlaces.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay recursos"));
    }

    @GetMapping("place/{id}/comentarios")
    public ResponseEntity<?> getPlaceComments (@PathVariable(value = "id") String uriId){
        Optional comentsByPlace = placeRepository.getCommentsForAdmin(uriId);
        return (comentsByPlace.isPresent()
                ? ResponseEntity.ok(comentsByPlace.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el recurso con id"+uriId));

    }



}
