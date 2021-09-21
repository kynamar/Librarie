/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import librarievirtuala.Rand;

/**
 *
 * @author Andrei
 */
public class RanduriTableModel extends AbstractTableModel {

    private List<Rand> listaRanduri;
    private String[] colums = new String[]{"Id", "Denumire"};

    public RanduriTableModel(List<Rand> listaRanduri) {
        this.listaRanduri = listaRanduri;
    }

    @Override
    public int getRowCount() {
        return listaRanduri.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column];
    }

    public Rand getRand(int index) {
        return listaRanduri.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rand rand = listaRanduri.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rand.getId();
            case 1:
                return rand.getNume();
            default:
                return "Unknown";
        }
    }

}
