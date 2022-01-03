package com.factories;

import com.entities.Diplomado;
import com.entities.Especializacion;
import com.entities.Programa;
import com.exceptions.InvalidProgramTypeException;
import com.utils.LineaProgramaEnum;
import com.utils.TipoProgramaEnum;

public class ProgramaFactory {
    public static Programa obtenerPrograma(TipoProgramaEnum tipoPrograma, LineaProgramaEnum linea, String nombre, int cantidadMaximaCursos) throws InvalidProgramTypeException{
        switch (tipoPrograma) {
            case Diplomado:
                return new Diplomado(linea, nombre,  cantidadMaximaCursos);
            case Especialización:
                return new Especializacion(linea, nombre,  cantidadMaximaCursos);
            default:
                throw new InvalidProgramTypeException();
        }
    }
}
