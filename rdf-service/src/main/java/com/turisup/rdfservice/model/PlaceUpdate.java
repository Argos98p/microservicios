package com.turisup.rdfservice.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PlaceUpdate {
    @NotNull
    String nombre;
    @NotNull
    double latitud;
    @NotNull
    double longitud;
    @NotNull
    String descripcion;
    @NotNull
    String usuarioId;
    @NotNull
    String categoria;
    String estado;
    String placeid;
}
