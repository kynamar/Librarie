/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderers;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import librarievirtuala.Categorie;

/**
 *
 * @author Andrei
 */
public class CategorieComboBoxRenderer extends BasicComboBoxRenderer{
     @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof Categorie) {
            Categorie categorie = (Categorie) value;
            setText(categorie.getNume());
        }
        return this;//super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
    }
}
