/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import librarievirtuala.Raft;

/**
 *
 * @author Andrei
 */
public class RafturiTableModel extends AbstractTableModel {

    private List<Raft> listaRafturi;
    private String[] colums = new String[]{"Id", "Denumire", "Numar coloane", "Numar randuri"};

    public RafturiTableModel(List<Raft> listaRafturi) {
        this.listaRafturi = listaRafturi;
    }

    @Override
    public int getRowCount() {
        return listaRafturi.size();
    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public String getColumnName(int column) {
        return colums[column];
    }

    public Raft getRaft(int index) {
        return listaRafturi.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raft raft = listaRafturi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return raft.getId();
            case 1:
                return raft.getNume();
            case 2:
                return raft.getColoanaMax();
            case 3:
                return raft.getLinieMax();
            default:
                return "Unknown";
        }
    }

}
