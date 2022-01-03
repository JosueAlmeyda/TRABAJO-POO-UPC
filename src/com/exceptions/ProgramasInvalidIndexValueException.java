package com.exceptions;

public class ProgramasInvalidIndexValueException extends Exception{
    @Override
    public String getMessage() {
        return "El programa buscado no existe en la lista.";
    }
}
