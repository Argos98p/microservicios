package com.turisup.rdfservice;

import com.complexible.stardog.api.Connection;
import com.turisup.rdfservice.Stardog.StardogProperties;
import com.turisup.rdfservice.Stardog.StardogConnection;
import com.turisup.rdfservice.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class RdfServiceApplication {

	@Autowired
	static PlaceRepository placeRepository;
	public static void main(String[] args) {SpringApplication.run(RdfServiceApplication.class, args);


	}

}
