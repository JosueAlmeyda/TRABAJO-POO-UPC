package com.entities;

import com.exceptions.CursoExistsException;
import com.exceptions.InvalidProgramTypeException;
import com.exceptions.ProfesorExistsException;
import com.exceptions.ProgramasInvalidIndexValueException;
import com.factories.ProgramaFactory;
import com.utils.LineaProgramaEnum;
import com.utils.TipoProgramaEnum;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    List<Profesor> profesores;
    List<Programa> programas;
    List<Curso> cursos;
    List<Seccion> seccions;

    private static Empresa instance = new Empresa();

    private Empresa() {
        this.programas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.seccions = new ArrayList<>();
    }

    public static Empresa getInstance() {
        return instance;
    }

    public List<Profesor> getProfesores() {
        return this.profesores;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Seccion> getSeccions() {
        return seccions;
    }

    public void crearProfesor(String nombres, String apellidos, String documento) throws ProfesorExistsException {
        if (profesores.stream().noneMatch(item -> item.getDocumento().equals(documento))) {
            Profesor nuevoProfesor = new Profesor(nombres,apellidos,documento);
            profesores.add(nuevoProfesor);
        } else {
            throw new ProfesorExistsException();
        }
    }

    public void crearPrograma(TipoProgramaEnum tipoPrograma, LineaProgramaEnum linea, String nombre, int cantidadMaximaCursos) throws InvalidProgramTypeException {
        Programa programa;
        switch (linea){
            case BI:
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,LineaProgramaEnum.BI, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            case SAP:
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,LineaProgramaEnum.SAP, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            case EXCEL:
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,LineaProgramaEnum.EXCEL, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            case PMP:
                programa = ProgramaFactory.obtenerPrograma(tipoPrograma,LineaProgramaEnum.PMP, nombre, cantidadMaximaCursos);
                programas.add(programa);
                break;
            default:
                throw new InvalidProgramTypeException();
        }
    }

    public void actualizarPrograma(Integer index, String nuevoNombre,Integer nuevaCantidad) throws  ProgramasInvalidIndexValueException{
        if (index < 0 || index > programas.size()) {
            throw new ProgramasInvalidIndexValueException();
        }
        programas.get(index).setNombre(nuevoNombre);
        programas.get(index).setCantidadMaximaCursos(nuevaCantidad);
    }

    public void crearCurso(String nombre) throws CursoExistsException {
        if (cursos.stream().noneMatch(item -> item.getNombre().equals(nombre))) {
            Curso nuevoCurso = new Curso(nombre);
            cursos.add(nuevoCurso);
        } else {
            throw new CursoExistsException();
        }
    }

    public void crearSeccion(String codigo, Curso curso, Profesor profesor, int cantidad, int año){
        Seccion seccion = new Seccion(codigo,curso,profesor,cantidad,año);
        seccions.add(seccion);
    }

}
