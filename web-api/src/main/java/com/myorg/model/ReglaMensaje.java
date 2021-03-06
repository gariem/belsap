package com.myorg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReglaMensaje {

    @Id
    int id;
    String tipo;
    @Column(columnDefinition = "TEXT")
    String pregunta;
    @Column(columnDefinition = "TEXT")
    String respuesta;
}
