package com.exceptions;

public class InvalidProgramTypeException extends Exception {
    @Override
    public String getMessage() {
        return "Tipo de programa inválido.";
    }
}
