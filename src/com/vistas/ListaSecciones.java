package com.vistas;

import com.entities.Empresa;
import com.entities.Programa;
import com.entities.Seccion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ListaSecciones {
    //private static ListaSecciones listaSecciones = new ListaSecciones();
    private JFrame frame = new JFrame();
    private JPanel myListaSecciones;
    private JButton asignarButton;
    private JTable tablaSecciones;
    private DefaultTableModel tbmodel = (DefaultTableModel) tablaSecciones.getModel();
    TableRowSorter<DefaultTableModel> tr;

    private Programa programa;
    private Seccion seccion;

    private Empresa empresa;

    public ListaSecciones(int index) {
        listarSecciones();
        programa = empresa.getProgramas().get(index);
        asignarButton.addActionListener(e -> asignarSeccion());

    }

    public void listarSecciones(){
        Object[] column = {"Código","Curso","Profesor","Cantidad","Año"};
        tbmodel.setColumnIdentifiers(column);
        tablaSecciones.setModel(tbmodel);
        tablaSecciones.setAutoCreateRowSorter(true);
        tr = new TableRowSorter<>(tbmodel);
        tablaSecciones.setRowSorter(tr);

        ////
        int rowCount = tbmodel.getRowCount();
        for(int i = rowCount-1; i>=0; i--){
            tbmodel.removeRow(i);
        }

        empresa = Empresa.getInstance();
        for (Seccion s:empresa.getSeccions()) {
            final Object[] tbRow = s.getObjetRow();
            tbmodel.addRow(tbRow);
        }

        //Estilos tabla Cursos
        tablaSecciones.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tablaSecciones.getTableHeader().setEnabled(false);
        tablaSecciones.getTableHeader().setOpaque(false);
        tablaSecciones.getTableHeader().setBackground(new Color(78,145,140));
        tablaSecciones.setRowHeight(25);
    }

    public void asignarSeccion(){
        int posicion = tablaSecciones.getSelectedRow();
        empresa = Empresa.getInstance();
        programa.asignarSeccion(empresa.getSeccions().get(posicion));
        JOptionPane.showMessageDialog( null, "Registro Realizado");
    }

    public void load(){
        this.frame.add(myListaSecciones); // agregar panel al objeto
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // detener programa al cerrar
        this.frame.setUndecorated(false); // mostrar ventanas windows
        this.frame.pack();  //mostrar contenido
        this.frame.setLocationRelativeTo(null); //mostrar al centro
        this.frame.setVisible(true);    // que sea visible
        this.frame.setResizable(true); // bloqueo cambiar tamaño de ventana
        this.frame.setSize(800,500);
    }
}
