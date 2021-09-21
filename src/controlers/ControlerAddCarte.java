/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditCarte;
import gui.FrmAddEditEditura;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import librarievirtuala.Autor;
import librarievirtuala.Carte;
import librarievirtuala.CarteAutor;
import librarievirtuala.Editura;

/**
 *
 * @author Andrei
 */
public class ControlerAddCarte {

    private Carte carteSelectata;
    private FrmAddEditCarte frmAddEditCarte;
    private JButton buttonSalvare;
    private JTextField txtNume;
    private JTextField txtIsbn;
    private JSpinner spnPret;
    private JComboBox<Editura> cmbEdituri;
    private JTextArea txtDescriere;
    private JList<Autor> lstAutori;
    private OnBusinessObjectSaved businessObjectSaved;
    private List<Editura> edituri = new ArrayList<Editura>();
    private List<Autor> autori = new ArrayList<Autor>();
    private DefaultComboBoxModel<Editura> comboBoxModel;
    private DefaultListModel<Autor> listModel;

    public ControlerAddCarte(Carte carte, FrmAddEditCarte frmAddEditCarte) {
        this.carteSelectata = carte;
        this.frmAddEditCarte = frmAddEditCarte;
        comboBoxModel = new DefaultComboBoxModel();
        listModel = new DefaultListModel<>();
        edituri.add(new Editura("Patrate"));
        edituri.add(new Editura("Romburi"));
        edituri.add(new Editura("Cultura"));
        autori.add(new Autor("Gigel", 1995));
        autori.add(new Autor("Petru", 2000));
        autori.add(new Autor("Mircea", 1980));
        for (Editura edit : edituri) {
            comboBoxModel.addElement(edit);
        }
        cmbEdituri.setModel(comboBoxModel);
        for (Autor autor : autori) {
            listModel.addElement(autor);
        }
        lstAutori.setModel(listModel);
    }

    public ControlerAddCarte(FrmAddEditCarte frmAddEditCarte) {
        this.frmAddEditCarte = frmAddEditCarte;
    }

    public void show() {
        if (carteSelectata != null) {
            frmAddEditCarte.getTxtDescriere().setText(carteSelectata.getDescriere());
            frmAddEditCarte.getTxtIsbn().setText(carteSelectata.getIsbn());
            frmAddEditCarte.getTxtNume().setText(carteSelectata.getTitlu());
            frmAddEditCarte.getSpnPret().setValue(carteSelectata.getPret());
            frmAddEditCarte.getCmbEdituri().setSelectedItem(carteSelectata.getEditura());
            /* for(CarteAutor carteAutor:carteSelectata.getAutori()){
                frmAddEditCarte.getLstAutori().add;
            }*/
        }
        buttonSalvare = frmAddEditCarte.getBtnSave();
        txtDescriere = frmAddEditCarte.getTxtDescriere();
        txtIsbn = frmAddEditCarte.getTxtIsbn();
        txtNume = frmAddEditCarte.getTxtNume();
        spnPret = frmAddEditCarte.getSpnPret();
        lstAutori = frmAddEditCarte.getLstAutori();
        cmbEdituri = frmAddEditCarte.getCmbEdituri();
        buttonSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbnCarte = txtIsbn.getText().trim();
                String denumireCarte = txtNume.getText().trim();
                double pretCarte = Double.parseDouble(spnPret.getValue().toString());
                String descriereCarte = txtDescriere.getText();
                if (carteSelectata == null) {
                    Carte carte = new Carte(isbnCarte, denumireCarte, descriereCarte, pretCarte);
                    carte.setEditura(cmbEdituri.getItemAt(cmbEdituri.getSelectedIndex()));
                    for (Autor autor : lstAutori.getSelectedValuesList()) {
                        carte.addAutor(autor);
                    }
                    businessObjectSaved.saveBusinessObject(carte);
                    frmAddEditCarte.dispose();
                }
                carteSelectata.setTitlu(denumireCarte);
                carteSelectata.setIsbn(isbnCarte);
                carteSelectata.setDescriere(descriereCarte);
                carteSelectata.setPret(pretCarte);
                carteSelectata.setEditura(cmbEdituri.getItemAt(cmbEdituri.getSelectedIndex()));
                for (Autor autor : lstAutori.getSelectedValuesList()) {

                    carteSelectata.addAutor(autor);
                }
                businessObjectSaved.saveBusinessObject(carteSelectata);
                frmAddEditCarte.dispose();
            }
        });
    }

}
