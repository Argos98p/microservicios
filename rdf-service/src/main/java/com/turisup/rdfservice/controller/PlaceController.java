package com.turisup.rdfservice.controller;

import com.turisup.rdfservice.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/place/{id}")
    public String placeById(@PathVariable(value = "id") String uriId) {
        placeRepository.getById(uriId, 0.0,0.0);
        return "hola;";
    }
}
