/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditAutor;
import gui.FrmAdministrareAutori;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import librarievirtuala.Autor;
import librarievirtuala.BusinessObjects;
import repositories.AutoriMemoryRepository;
import servicies.AutoriService;
import servicies.AutoriServiceImpl;
import servicies.EdituriService;
import servicies.EdituriServiceImpl;
import tablemodels.AutoriTableModel;
import tablemodels.EdituriTableModel;

/**
 *
 * @author Andrei
 */
public class ControlerAdministrareAutori implements OnBusinessObjectSaved {

    private ArrayList<Autor> autori;
    private FrmAdministrareAutori frmAdministrareAutori;
    private JButton btnAddAutor;
    private JButton btnEditAutor;
    private JButton btnDeleteAutor;
    private JTable autoriTable;
    private AutoriService autoriService = AutoriServiceImpl.getInstance();
    private AutoriTableModel autoriTableModel;

    public ControlerAdministrareAutori(ArrayList<Autor> autori,FrmAdministrareAutori frmAdministrareAutori) {
        this.autori=autori;
        this.frmAdministrareAutori=frmAdministrareAutori;
        autoriService.setAutorRepository(new AutoriMemoryRepository());
        autoriTableModel=new AutoriTableModel(autoriService.getAutori());
        this.frmAdministrareAutori.getTableAutori().setModel(autoriTableModel);
    }
    
 public void show(){
     btnAddAutor=frmAdministrareAutori.getBtnAdd();
     btnEditAutor=frmAdministrareAutori.getBtnEdit();
     btnDeleteAutor=frmAdministrareAutori.getBtnDelete();
     autoriTable=frmAdministrareAutori.getTableAutori();
     btnAddAutor.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             FrmAddEditAutor addEditAutor = new FrmAddEditAutor(frmAdministrareAutori, true);
        ControlerAddAutor controlerAddAutor = new ControlerAddAutor(addEditAutor);
        controlerAddAutor.setBusinessObjectSaved(ControlerAdministrareAutori.this);
        controlerAddAutor.show();
         }
     });
     btnEditAutor.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int index = frmAdministrareAutori.getTableAutori().convertRowIndexToModel(frmAdministrareAutori.getTableAutori().getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(frmAdministrareAutori, "Va rog selectati un Autor");
            return;
        }
        Autor a = autoriTableModel.getAutor(index);
        FrmAddEditAutor addEditAutor = new FrmAddEditAutor(frmAdministrareAutori, true);
        ControlerAddAutor controlerAddAutor = new ControlerAddAutor(addEditAutor, a);
        controlerAddAutor.setBusinessObjectSaved(ControlerAdministrareAutori.this);
        controlerAddAutor.show();
         }
     });
     btnDeleteAutor.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int index = frmAdministrareAutori.getTableAutori().convertRowIndexToModel(frmAdministrareAutori.getTableAutori().getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(frmAdministrareAutori, "Va rog selectati un Autor");
            return;
        }
        int raspuns = JOptionPane.showConfirmDialog(frmAdministrareAutori, "Sunteti sigur ca doriti sa stergeti aceast autor?", "Stergere autor", JOptionPane.YES_NO_OPTION);
        if (raspuns == JOptionPane.YES_OPTION) {
            Autor a = autoriTableModel.getAutor(index);
            autoriService.removeAutor(a);
            autoriTableModel.fireTableDataChanged();
         }
         }
     });
     frmAdministrareAutori.setVisible(true);
 }
    @Override
    public void saveBusinessObject(BusinessObjects bo) {
        Autor autor = (Autor) bo;
        int index = autoriService.getAutori().indexOf(bo);
        if (index == -1) {
            autoriService.saveAutor(autor);
            autoriTableModel.fireTableDataChanged();
            return;
        }
        autoriService.getAutori().set(index, autor);
        autoriTableModel.fireTableDataChanged();
    }

}
