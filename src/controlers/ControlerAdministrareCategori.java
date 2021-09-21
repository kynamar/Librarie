/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditCategorie;
import gui.FrmAdministrareCategori;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import librarievirtuala.BusinessObjects;
import librarievirtuala.Categorie;
import repositories.CategoriMemoryRepository;
import servicies.CategoriService;
import servicies.CategoriServiceImpl;
import servicies.EdituriService;
import tablemodels.CategoriTableModel;

/**
 *
 * @author Andrei
 */
public class ControlerAdministrareCategori implements OnBusinessObjectSaved {

    private ArrayList<Categorie> categori;
    private FrmAdministrareCategori frmAdministrareCategori;
    private JButton btnAddCategorie;
    private JButton btnEditCategorie;
    private JButton btnDeleteCategorie;
    private JTable categoriTable;
    private CategoriService categoriService = CategoriServiceImpl.getInstance();
    private CategoriTableModel categoriTableModel;

    public ControlerAdministrareCategori(ArrayList<Categorie> categori, FrmAdministrareCategori frmAdministrareCategori) {
        this.categori = categori;
        this.frmAdministrareCategori = frmAdministrareCategori;
        categoriService.setCategoriRepository(new CategoriMemoryRepository());
        categoriTableModel = new CategoriTableModel(categoriService.getCategori());
        this.frmAdministrareCategori.getTableCategori().setModel(categoriTableModel);
    }

    public ControlerAdministrareCategori(FrmAddEditCategorie frmAddEditCategorie) {
        this.frmAdministrareCategori = frmAdministrareCategori;
        categoriService.setCategoriRepository(new CategoriMemoryRepository());
        categoriTableModel = new CategoriTableModel(categoriService.getCategori());
        this.frmAdministrareCategori.getTableCategori().setModel(categoriTableModel);
    }

    public void show() {
        btnAddCategorie = frmAdministrareCategori.getBtnAdd();
        btnEditCategorie = frmAdministrareCategori.getBtnEdit();
        btnDeleteCategorie = frmAdministrareCategori.getBtnDelete();
        categoriTable = frmAdministrareCategori.getTableCategori();
        btnAddCategorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAddEditCategorie addEditCategorie = new FrmAddEditCategorie(frmAdministrareCategori, true);
                ControlerAddCategorie controlerAddCategorie = new ControlerAddCategorie(addEditCategorie);
                controlerAddCategorie.setBusinessObjectSaved(ControlerAdministrareCategori.this);
                controlerAddCategorie.show();
            }
        });
        btnEditCategorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = frmAdministrareCategori.getTableCategori().convertRowIndexToModel(frmAdministrareCategori.getTableCategori().getSelectedRow());
                if (index == -1) {
                    JOptionPane.showMessageDialog(frmAdministrareCategori, "Va rog selectati o Categorie");
                    return;
                }
                Categorie c = categoriTableModel.getCategorie(index);
                FrmAddEditCategorie addEditCategorie = new FrmAddEditCategorie(frmAdministrareCategori, true);
                ControlerAddCategorie controlerAddCategorie = new ControlerAddCategorie(c, addEditCategorie);
                controlerAddCategorie.setBusinessObjectSaved(ControlerAdministrareCategori.this);
                controlerAddCategorie.show();
            }
        });
        btnDeleteCategorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = frmAdministrareCategori.getTableCategori().convertRowIndexToModel(frmAdministrareCategori.getTableCategori().getSelectedRow());
                if (index == -1) {
                    JOptionPane.showMessageDialog(frmAdministrareCategori, "Va rog selectati o Categorie");
                    return;
                }
                int raspuns = JOptionPane.showConfirmDialog(frmAdministrareCategori, "Sunteti sigur ca doriti sa stergeti aceasta categorie?", "Stergere categorie", JOptionPane.YES_NO_OPTION);
                if (raspuns == JOptionPane.YES_OPTION) {
                    Categorie c = categoriTableModel.getCategorie(index);
                    categoriService.removeCategorie(c);
                    categoriTableModel.fireTableDataChanged();
                }
            }
        });
        frmAdministrareCategori.setVisible(true);
    }

    @Override
    public void saveBusinessObject(BusinessObjects bo) {
        Categorie categorie = (Categorie) bo;
        int index = categoriService.getCategori().indexOf(bo);
        if (index == -1) {
            categoriService.saveCategorie(categorie);
            categoriTableModel.fireTableDataChanged();
            return;
        }
        categoriService.getCategori().set(index, categorie);
        categoriTableModel.fireTableDataChanged();
    }

}
