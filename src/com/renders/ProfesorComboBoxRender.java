package com.renders;

import com.entities.Profesor;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class ProfesorComboBoxRender extends BasicComboBoxRenderer {
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Profesor)
        {
            Profesor profesor = (Profesor) value;
            setText( profesor.getNombres() + " " + profesor.getApellidos() + " - " + profesor.getDocumento() );
        }

        return this;
    }
}
