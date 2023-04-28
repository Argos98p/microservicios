package com.turisup.rdfservice.model;

import lombok.Data;

@Data
public class PlacePoint {
    double latitud;
    double longitud;

    public PlacePoint() {
    }
    public PlacePoint(double latitud,double longitud) {
        this.latitud=latitud;
        this.longitud=longitud;
    }
}
