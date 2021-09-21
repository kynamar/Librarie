/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditCategorie;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import librarievirtuala.Categorie;
import librarievirtuala.Editura;

/**
 *
 * @author Andrei
 */
public class ControlerAddCategorie {

    private Categorie categorieSelectata;
    private FrmAddEditCategorie frmAddEditCategorie;
    private JButton btnSalvare;
    private JTextField txtDenumire;
    private JTextArea txtDescriere;
    private OnBusinessObjectSaved businessObjectSaved;

    public ControlerAddCategorie(Categorie categorie, FrmAddEditCategorie frmAddEditCategorie) {
        this.categorieSelectata = categorie;
        this.frmAddEditCategorie = frmAddEditCategorie;
    }

    public ControlerAddCategorie(FrmAddEditCategorie frmAddEditCategorie) {
        this.frmAddEditCategorie = frmAddEditCategorie;
    }

    public void show() {
        if (categorieSelectata != null) {
            frmAddEditCategorie.getTxtDenumire().setText(categorieSelectata.getNume());
            frmAddEditCategorie.getTxtDescriere().setText(categorieSelectata.getDescriere());
        }
        btnSalvare = frmAddEditCategorie.getBtnSalvare();
        txtDenumire = frmAddEditCategorie.getTxtDenumire();
        txtDescriere = frmAddEditCategorie.getTxtDescriere();
        btnSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String denumireCategorie = txtDenumire.getText().trim();
                String descriereCategorie = txtDescriere.getText();
                if (categorieSelectata == null) {
                    Categorie categorie = new Categorie(denumireCategorie, descriereCategorie);
                    businessObjectSaved.saveBusinessObject(categorie);
                } else {
                    categorieSelectata.setNume(denumireCategorie);
                    categorieSelectata.setDescriere(descriereCategorie);
                    businessObjectSaved.saveBusinessObject(categorieSelectata);
                }
                frmAddEditCategorie.dispose();
            }
        });
        frmAddEditCategorie.setLocationRelativeTo(null);
        frmAddEditCategorie.setVisible(true);
    }

    public void setBusinessObjectSaved(OnBusinessObjectSaved businessObjectSaved) {
        this.businessObjectSaved = businessObjectSaved;
    }

}
