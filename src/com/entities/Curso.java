package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public Object[] getObjetRow() {
        final Object[] row = new Object[1];
        row[0] = nombre;
        return row;
    }

    public String getNombre() {
        return nombre;
    }
}