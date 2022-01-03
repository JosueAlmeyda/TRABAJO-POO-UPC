package com.renders;

import com.entities.Curso;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class CursoComboBoxRender extends BasicComboBoxRenderer {
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Curso)
        {
            Curso curso = (Curso) value;
            setText( curso.getNombre() );
        }

        return this;
    }
}
