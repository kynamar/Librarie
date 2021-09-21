/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditEditura;
import gui.FrmAdministrareEdituri;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import librarievirtuala.BusinessObjects;
import librarievirtuala.Editura;
import repositories.EdituriMemoryRepository;
import servicies.EdituriService;
import servicies.EdituriServiceImpl;
import tablemodels.EdituriTableModel;

/**
 *
 * @author Andrei
 */
public class ControlerAdministrareEdituri implements OnBusinessObjectSaved {

    private ArrayList<Editura> edituri;
    private FrmAdministrareEdituri frmAdministrareEdituri;
    private JButton btnAddEditura;
    private JButton btnEditEditura;
    private JButton btnDeleteEditura;
    private JTable edituriTable;
    private EdituriService edituriService = EdituriServiceImpl.getInstance();
    private EdituriTableModel edituriTableModel;

    public ControlerAdministrareEdituri(ArrayList<Editura> edituri, FrmAdministrareEdituri frmAdministrareEdituri) {
        this.edituri = edituri;
        this.frmAdministrareEdituri = frmAdministrareEdituri;
        edituriService.setEdituraRepository(new EdituriMemoryRepository());
        edituriTableModel = new EdituriTableModel(edituriService.getEdituri());
        this.frmAdministrareEdituri.getTableEdituri().setModel(edituriTableModel);
    }

    public ControlerAdministrareEdituri(FrmAdministrareEdituri frmAdministrareEdituri) {
        this.frmAdministrareEdituri = frmAdministrareEdituri;
        edituriService.setEdituraRepository(new EdituriMemoryRepository());
        edituriTableModel = new EdituriTableModel(edituriService.getEdituri());
        this.frmAdministrareEdituri.getTableEdituri().setModel(edituriTableModel);
    }

    public void show() {
        btnAddEditura = frmAdministrareEdituri.getBtnAdd();
        btnEditEditura = frmAdministrareEdituri.getBtnEdit();
        btnDeleteEditura = frmAdministrareEdituri.getBtnDelete();
        edituriTable = frmAdministrareEdituri.getTableEdituri();
        btnAddEditura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAddEditEditura addEditEditura = new FrmAddEditEditura(frmAdministrareEdituri, true);
                ControlerAddEditura controlerAddEditura = new ControlerAddEditura(addEditEditura);
                controlerAddEditura.setBusinessObjectSaved(ControlerAdministrareEdituri.this);
                controlerAddEditura.show();
            }
        });
        btnEditEditura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = frmAdministrareEdituri.getTableEdituri().convertRowIndexToModel(frmAdministrareEdituri.getTableEdituri().getSelectedRow());
                if (index == -1) {
                    JOptionPane.showMessageDialog(frmAdministrareEdituri, "Va rog selectati o Editura");
                    return;
                }
                Editura editura = edituriTableModel.getEditura(index);
                FrmAddEditEditura addEditEditura = new FrmAddEditEditura(frmAdministrareEdituri, true);

                ControlerAddEditura controlerAddEditura = new ControlerAddEditura(editura, addEditEditura);
                controlerAddEditura.setBusinessObjectSaved(ControlerAdministrareEdituri.this);
                controlerAddEditura.show();
            }
        });
        btnDeleteEditura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexx = frmAdministrareEdituri.getTableEdituri().convertRowIndexToModel(frmAdministrareEdituri.getTableEdituri().getSelectedRow());
                if (indexx == -1) {
                    JOptionPane.showMessageDialog(frmAdministrareEdituri, "Va rog selectati o Editura");
                    return;
                }
                int raspuns = JOptionPane.showConfirmDialog(frmAdministrareEdituri, "Sunteti sigur ca doriti sa stergeti aceasta editura?", "Stergere editura", JOptionPane.YES_NO_OPTION);
                if (raspuns == JOptionPane.YES_OPTION) {
                    Editura editura2 = edituriTableModel.getEditura(indexx);
                    edituriService.removeEditura(editura2);
                    edituriTableModel.fireTableDataChanged();
                }
            }
        });
        frmAdministrareEdituri.setVisible(true);
    }

    @Override

    public void saveBusinessObject(BusinessObjects bo) {
        Editura editura = (Editura) bo;
        int index = edituriService.getEdituri().indexOf(bo);
        //System.out.println("Editura info "+editura.getId());
        if (index == -1) {
            edituriService.saveEditura(editura);
            edituriTableModel.fireTableDataChanged();
            return;
        }
        edituriService.getEdituri().set(index, editura);
        edituriTableModel.fireTableDataChanged();
    }

}
