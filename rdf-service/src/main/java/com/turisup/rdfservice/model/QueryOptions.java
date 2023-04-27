package com.turisup.rdfservice.model;

import lombok.Data;

@Data
public class QueryOptions {
    String organizacionId;
    String regionId;
    String creadorId;
    String lugarId;
    String estadoLugar;
    Double latitud;
    Double longitud;
    Double distanciaMax;
    String buscar;
    String userId;
    String nodeForRouteBag;
}