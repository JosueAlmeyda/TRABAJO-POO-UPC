package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    //private static Seccion seccion = new Seccion();
    private String codigo;
    private Curso curso;
    private Profesor profesor;
    private int capacidad;
    private int año;

    public Seccion(String codigo, Curso curso, Profesor profesor, int capacidad, int año) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.año = año;
        this.profesor = profesor;
        this.curso = curso;
    }

    public Seccion(){

    }

    public Object[] getObjetRow() {
        final Object[] row = new Object[5];
        row[0] = codigo;
        row[1] = curso.getNombre();
        row[2] = profesor.getNombres();
        row[3] = capacidad;
        row[4] = año;
        return row;
    }
}
