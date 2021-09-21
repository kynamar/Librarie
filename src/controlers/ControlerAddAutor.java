/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditAutor;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import librarievirtuala.Autor;
import librarievirtuala.BusinessObjects;

public class ControlerAddAutor {
    
    private FrmAddEditAutor frmAddEditAutor;
    private Autor autorSelectat;
    private JButton btnSalvare;
    private JTextField txtNume;
    private JSpinner spnAnulNasteri;
    private OnBusinessObjectSaved businessObjectSaved;
    
    public ControlerAddAutor(FrmAddEditAutor frmAddEditAutor, Autor autor) {
        this.autorSelectat = autor;
        this.frmAddEditAutor = frmAddEditAutor;
    }
    
    public ControlerAddAutor(FrmAddEditAutor frmAddEditAutor) {
        this.frmAddEditAutor = frmAddEditAutor;
    }
    
    public void show() {
        if (autorSelectat != null) {
            frmAddEditAutor.getTxtNume().setText(autorSelectat.getNume());
            frmAddEditAutor.getSpnAnulNasteri().setValue(autorSelectat.getAnulNasteri());
        }
        btnSalvare = frmAddEditAutor.getBtnSalvare();
        txtNume = frmAddEditAutor.getTxtNume();
        spnAnulNasteri = frmAddEditAutor.getSpnAnulNasteri();
        btnSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeAutor = txtNume.getText().trim();
                int anulNasteriAutor = Integer.parseInt(spnAnulNasteri.getValue().toString());
                if (autorSelectat == null) {
                    Autor autor = new Autor(numeAutor, anulNasteriAutor);
                    businessObjectSaved.saveBusinessObject(autor);
                } else {
                    autorSelectat.setNume(numeAutor);
                    autorSelectat.setAnulNasteri(anulNasteriAutor);
                    businessObjectSaved.saveBusinessObject(autorSelectat);
                }
                frmAddEditAutor.dispose();
            }
        });
        frmAddEditAutor.setLocationRelativeTo(null);
        frmAddEditAutor.setVisible(true);
    }
    
    public void setBusinessObjectSaved(OnBusinessObjectSaved businessObjectSaved) {
        this.businessObjectSaved = businessObjectSaved;
    }
    
}
