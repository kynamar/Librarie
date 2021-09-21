/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderers;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import librarievirtuala.Carte;

/**
 *
 * @author Andrei
 */
public class CarteListRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value != null) {
            Carte entry = (Carte) value;
            renderer.setText(entry.getTitlu());
        }
        return renderer;
    }
}
