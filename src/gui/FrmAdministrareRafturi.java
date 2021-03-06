/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.OnBusinessObjectSaved;
import javax.swing.JOptionPane;
import librarievirtuala.BusinessObjects;
import librarievirtuala.Raft;
import repositories.RafturiMEmoryRepository;
import servicies.RafturiService;
import servicies.RafturiServiceImpl;
import tablemodels.RafturiTableModel;

/**
 *
 * @author Andrei
 */
public class FrmAdministrareRafturi extends javax.swing.JDialog implements OnBusinessObjectSaved {

    private RafturiService rafturiService = RafturiServiceImpl.getInstance();
    private RafturiTableModel rafturiTableModel;

    /**
     * Creates new form FrmAdministrareRaft
     */
    public FrmAdministrareRafturi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        rafturiService.setRaftRepository(new RafturiMEmoryRepository());
        rafturiTableModel = new RafturiTableModel(rafturiService.getRafturi());
        initComponents();
        tableRafturi.setModel(rafturiTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRafturi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAdd.setText("Adauga");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

        btnEdit.setText("Editeaza");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnDelete.setText("Sterge");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        tableRafturi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableRafturi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        FrmAddEditRaft addEditRaft = new FrmAddEditRaft(this, true);
       // addEditRaft.setBusinessObjectSaved(this);
        addEditRaft.setLocationRelativeTo(this);
        addEditRaft.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int index = tableRafturi.convertRowIndexToModel(tableRafturi.getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Va rog selectati un raft");
            return;
        }
        Raft r = rafturiTableModel.getRaft(index);
        //FrmAddEditRaft addEditRaft = new FrmAddEditRaft(r, this, true);
        //addEditRaft.setBusinessObjectSaved(this);
        //addEditRaft.setLocationRelativeTo(this);
        //addEditRaft.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tableRafturi.convertRowIndexToModel(tableRafturi.getSelectedRow());
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Va rog selectati un raft");
            return;
        }
        int raspuns = JOptionPane.showConfirmDialog(this, "Sunteti sigur ca doriti sa stergeti aceasta raft?", "Stergere raft", JOptionPane.YES_NO_OPTION);
        if (raspuns == JOptionPane.YES_OPTION) {
            Raft r = rafturiTableModel.getRaft(index);
            rafturiService.removeRaft(r);
            rafturiTableModel.fireTableDataChanged();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrareRafturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrareRafturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrareRafturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdministrareRafturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAdministrareRafturi dialog = new FrmAdministrareRafturi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRafturi;
    // End of variables declaration//GEN-END:variables

    @Override
    public void saveBusinessObject(BusinessObjects bo) {
        Raft raft = (Raft) bo;
        int index = rafturiService.getRafturi().indexOf(bo);
        //System.out.println("Editura info "+editura.getId());
        if (index == -1) {
            rafturiService.saveRaft(raft);
            rafturiTableModel.fireTableDataChanged();
            return;
        }
        rafturiService.getRafturi().set(index, raft);
        rafturiTableModel.fireTableDataChanged();
    }
}
