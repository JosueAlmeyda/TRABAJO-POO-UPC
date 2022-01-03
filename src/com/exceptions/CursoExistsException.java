package com.exceptions;

public class CursoExistsException extends Exception {
    @Override
    public String getMessage() {
        return "Curso ya existe en la lista.";
    }
}
