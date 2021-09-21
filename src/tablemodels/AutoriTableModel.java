/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import librarievirtuala.Autor;

/**
 *
 * @author Andrei
 */
public class AutoriTableModel extends AbstractTableModel {

    private List<Autor> listaAutori;
    private String[] colums = new String[]{"Id", "Nume", "Anul nasteri"};

    public AutoriTableModel(List<Autor> listaAutori) {
        this.listaAutori = listaAutori;
    }

    @Override
    public int getRowCount() {
        return listaAutori.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column];
    }

    public Autor getAutor(int index) {
        return listaAutori.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = listaAutori.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return autor.getId();
            case 1:
                return autor.getNume();
            case 2:
                return autor.getAnulNasteri();
            default:
                return "Unknown";
        }
    }

}
