/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditEditura;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import librarievirtuala.Editura;

/**
 *
 * @author Andrei
 */
public class ControlerAddEditura {

    private Editura edituraSelectata;
    private FrmAddEditEditura frmAddEditEditura;
    private JButton buttonSalvare;
    private JTextField txtDenumire;
    private OnBusinessObjectSaved businessObjectSaved;

    public ControlerAddEditura(Editura editura, FrmAddEditEditura frmAddEditEditura) {
        this.edituraSelectata = editura;
        this.frmAddEditEditura = frmAddEditEditura;
    }

    public ControlerAddEditura(FrmAddEditEditura frmAddEditEditura) {
        this.frmAddEditEditura = frmAddEditEditura;
    }

    public void show() {
        if (edituraSelectata != null) {
            frmAddEditEditura.getTxtDenumire().setText(edituraSelectata.getNume());
        }
        buttonSalvare = frmAddEditEditura.getBtnSalvare();
        txtDenumire = frmAddEditEditura.getTxtDenumire();
        buttonSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String denumireEditura = txtDenumire.getText().trim();
                if (edituraSelectata == null) {
                    Editura editura = new Editura(denumireEditura);
                    businessObjectSaved.saveBusinessObject(editura);
                } else {
                    edituraSelectata.setNume(denumireEditura);
                    businessObjectSaved.saveBusinessObject(edituraSelectata);
                }
                frmAddEditEditura.dispose();

            }
        });
        frmAddEditEditura.setLocationRelativeTo(null);
        frmAddEditEditura.setVisible(true);

    }

    public void setBusinessObjectSaved(OnBusinessObjectSaved businessObjectSaved) {
        this.businessObjectSaved = businessObjectSaved;
    }

}
