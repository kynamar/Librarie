/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import librarievirtuala.Categorie;

/**
 *
 * @author Andrei
 */
public class CategoriTableModel extends AbstractTableModel {

    private List<Categorie> listaCategori;
    private String[] colums = new String[]{"Id", "Denumire", "Descriere"};

    public CategoriTableModel(List<Categorie> listaCategori) {
        this.listaCategori = listaCategori;
    }

    @Override
    public int getRowCount() {
        return listaCategori.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public Categorie getCategorie(int index) {
        return listaCategori.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categorie categorie = listaCategori.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return categorie.getId();
            case 1:
                return categorie.getNume();
            case 2:
                return categorie.getDescriere();
            default:
                return "Unknown";
        }
    }

}
