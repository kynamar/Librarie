/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import gui.FrmAddEditRaft;
import interfaces.OnBusinessObjectSaved;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import librarievirtuala.Raft;

/**
 *
 * @author Andrei
 */
public class ControlerAddRaft {
    private Raft raftSelectat;
    private FrmAddEditRaft frmAddEditRaft;
    private JButton buttonSalvare;
    private JTextField txtDenumire;
    private JSpinner spnNrColoane;
    private JSpinner spnNrLinii;
    private OnBusinessObjectSaved businessObjectSaved;

    public ControlerAddRaft(Raft raft, FrmAddEditRaft frmAddEditRaft) {
        this.raftSelectat = raft;
        this.frmAddEditRaft = frmAddEditRaft;
    }

    public ControlerAddRaft(FrmAddEditRaft frmAddEditRaft) {
        this.frmAddEditRaft = frmAddEditRaft;
    }

    public void show() {
        if (raftSelectat != null) {
            frmAddEditRaft.getTxtNume().setText(raftSelectat.getNume());
            frmAddEditRaft.getSpnNrColoane().setValue(raftSelectat.getColoanaMax());
            frmAddEditRaft.getSpnNrLinii().setValue(raftSelectat.getLinieMax());
        }
        buttonSalvare = frmAddEditRaft.getBtnSave();
        txtDenumire = frmAddEditRaft.getTxtNume();
        spnNrColoane=frmAddEditRaft.getSpnNrColoane();
        spnNrLinii=frmAddEditRaft.getSpnNrLinii();
        buttonSalvare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String denumireRaft = txtDenumire.getText().trim();
        int nrLinii = Integer.parseInt(spnNrLinii.getValue().toString());
        int nrColoane = Integer.parseInt(spnNrColoane.getValue().toString());
        if (raftSelectat == null) {
            Raft raft = new Raft(denumireRaft, nrColoane, nrLinii);
            businessObjectSaved.saveBusinessObject(raft);
        } else {
            raftSelectat.setNume(denumireRaft);
            raftSelectat.setColoanaMax(nrColoane);
            raftSelectat.setLinieMax(nrLinii);
            businessObjectSaved.saveBusinessObject(raftSelectat);
        }
        frmAddEditRaft.dispose();    
            }
        });
        frmAddEditRaft.setLocationRelativeTo(null);
        frmAddEditRaft.setVisible(true);

    }

    public void setBusinessObjectSaved(OnBusinessObjectSaved businessObjectSaved) {
        this.businessObjectSaved = businessObjectSaved;
    }
}
