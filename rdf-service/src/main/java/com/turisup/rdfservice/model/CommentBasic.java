package com.turisup.rdfservice.model;

import lombok.Data;

@Data
public class CommentBasic {
    String comentario;
    String lugarId;
    String fecha;
    String contenido;
    Double rate;

    public CommentBasic(String placeId, String commentId, String fecha, Double rate, String contenido) {
        this.lugarId=placeId;
        this.comentario=commentId;
        this.fecha=fecha;
        this.rate=rate;
        this.contenido=contenido;
    }
}
