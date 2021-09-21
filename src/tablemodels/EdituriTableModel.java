/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import librarievirtuala.Editura;

/**
 *
 * @author Andrei
 */
public class EdituriTableModel extends AbstractTableModel {

    private List<Editura> listaEdituri;
    private String[] columns = new String[]{"Id", "Denumire"};

    public EdituriTableModel(List<Editura> listaEdituri) {
        this.listaEdituri = listaEdituri;
    }

    @Override
    public int getRowCount() {
        return listaEdituri.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Editura editura = listaEdituri.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return editura.getId();
            case 1:
                return editura.getNume();
            default:
                return "Unknown";
        }
    }
    
    public Editura getEditura(int index){
        return listaEdituri.get(index);
    }

//    public void setListaEdituri(List<Editura> listaEdituri) {
//        this.listaEdituri = listaEdituri;
//        fireTableDataChanged();
//    }
}
