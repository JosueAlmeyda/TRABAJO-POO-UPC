package com.exceptions;

public class ProfesorExistsException extends Exception {
    @Override
    public String getMessage() {
        return "Profesor ya existe en la lista.";
    }
}
