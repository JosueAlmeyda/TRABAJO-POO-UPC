package com.vistas;

import com.entities.Empresa;
import com.entities.Programa;
import com.exceptions.ProgramasInvalidIndexValueException;

import javax.swing.*;


public class ModificarPrograma {

    private JPanel myModificarPrograma;
    private JTextField textModPrograma;
    private JTextField textModLinea;
    private JTextField textModNombre;
    private JTextField textModCantidad;
    private JButton buttonActualizarCurso;
    private JFrame frame = new JFrame();
    private int index;
    PortalProgramas portalProgramas;

    private Empresa empresa;

    public ModificarPrograma(int indice) {
        this.index=indice;
        empresa = Empresa.getInstance();
        Programa programa = empresa.getProgramas().get(index);
        textModPrograma.setText(programa.getClass().getSimpleName());
        textModLinea.setText(programa.getLinea().toString());
        textModNombre.setText(programa.getNombre());
        textModCantidad.setText(String.valueOf(programa.getCantidadMaximaCursos()));

        buttonActualizarCurso.addActionListener(e ->actualizarCurso());

    }

    public void actualizarCurso(){
        empresa = Empresa.getInstance();
        try {
            empresa.actualizarPrograma(index,textModNombre.getText(),Integer.parseInt(textModCantidad.getText()));
        } catch (ProgramasInvalidIndexValueException e) {
            System.out.println(e.getMessage());
        }
        portalProgramas = PortalProgramas.getInstance();
        portalProgramas.listarPrograma();

    }

    public void load(){
        this.frame.add(myModificarPrograma); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setSize(650,350);
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
    }
}
