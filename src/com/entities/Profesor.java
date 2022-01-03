package com.entities;

public class Profesor {//extends Persona {
    private String nombres;
    private String apellidos;
    private String documento;

    public Profesor(String nombres, String apellidos, String documento) {
        //super(nombres, apellidos, documento);
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.documento=documento;

    }
    public Object[] getObjetRow() {
        final Object[] row = new Object[3];
        row[0] = nombres;
        row[1] = apellidos;
        row[2] = documento;
        return row;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }
}
