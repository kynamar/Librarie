/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import librarievirtuala.Carte;

/**
 *
 * @author Andrei
 */
public class CartiTableModel extends AbstractTableModel {

    private List<Carte> listaCarti;
    private String[] colums = new String[]{"Id", "Isbn", "Titlu", "Descriere", "Pret"};

    public CartiTableModel(List<Carte> listaCarti) {
        this.listaCarti = listaCarti;
    }

    @Override
    public int getRowCount() {
        return listaCarti.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column];
    }

    public Carte getCarte(int index) {
        return listaCarti.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carte carte = listaCarti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return carte.getId();
            case 1:
                return carte.getIsbn();
            case 2:
                return carte.getTitlu();
            case 3:
                return carte.getDescriere();
            case 4:
                return carte.getPret();
            default:
                return "Unknown";
        }
    }

}
