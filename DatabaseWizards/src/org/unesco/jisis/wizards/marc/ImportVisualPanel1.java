/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unesco.jisis.wizards.marc;

import javax.swing.JPanel;
import org.openide.WizardDescriptor;
import org.openide.util.NbBundle;
import org.unesco.jisis.corelib.client.ConnectionInfo;
import org.unesco.jisis.corelib.client.ConnectionPool;
import org.unesco.jisis.corelib.common.IDatabase;


public final class ImportVisualPanel1 extends JPanel {


   public final static int IMPORT_IN_EXISTING_DB = 0;
   public final static int IMPORT_CREATE_EMPTY_DB = 1;
   public final static int IMPORT_CREATE_DB_FROM_FDT = 2;

   private int import_ = IMPORT_IN_EXISTING_DB;

    /** Creates new form ImportVisualPanel1 */
     private ImportWizardPanel1 wizardDescriptor_;

    /**
     * Creates new form ImportVisualPanel2
     */
    public ImportVisualPanel1(ImportWizardPanel1 wizardDescriptor) {
        wizardDescriptor_ = wizardDescriptor;
        initComponents();
        ConnectionInfo connectionInfo = ConnectionPool.getDefaultConnectionInfo();
        IDatabase targetDB = connectionInfo.getDefaultDatabase();

        if (targetDB != null) {
            txtDbName.setText(targetDB.getDbName());
        }

    }
    boolean valid(WizardDescriptor wizardDescriptor) {
        if (import_ == ImportVisualPanel1.IMPORT_IN_EXISTING_DB) {
            ConnectionInfo connectionInfo = ConnectionPool.getDefaultConnectionInfo();
            IDatabase targetDB = connectionInfo.getDefaultDatabase();

            if (targetDB == null) {
                wizardDescriptor.putProperty("WizardPanel_errorMessage", // NOI18N
                    NbBundle.getMessage(ImportVisualPanel1.class, "MSG_NoDatabaseOpened"));
                return false;
            }

        }

        return true;

    }
    @Override
    public String getName() {
        return "Import Type";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      buttonGroup1 = new javax.swing.ButtonGroup();
      rdbCreateDbFromFDT = new javax.swing.JRadioButton();
      rdbImportAndCreateDB = new javax.swing.JRadioButton();
      rdbImportInExistingDB = new javax.swing.JRadioButton();
      jSeparator1 = new javax.swing.JSeparator();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      txtDbName = new javax.swing.JTextField();

      buttonGroup1.add(rdbCreateDbFromFDT);
      org.openide.awt.Mnemonics.setLocalizedText(rdbCreateDbFromFDT, org.openide.util.NbBundle.getMessage(ImportVisualPanel1.class, "ImportVisualPanel1.rdbCreateDbFromFDT.text")); // NOI18N
      rdbCreateDbFromFDT.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            rdbCreateDbFromFDTActionPerformed(evt);
         }
      });

      buttonGroup1.add(rdbImportAndCreateDB);
      org.openide.awt.Mnemonics.setLocalizedText(rdbImportAndCreateDB, org.openide.util.NbBundle.getMessage(ImportVisualPanel1.class, "ImportVisualPanel1.rdbImportAndCreateDB.text")); // NOI18N
      rdbImportAndCreateDB.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            rdbImportAndCreateDBActionPerformed(evt);
         }
      });

      buttonGroup1.add(rdbImportInExistingDB);
      rdbImportInExistingDB.setSelected(true);
      org.openide.awt.Mnemonics.setLocalizedText(rdbImportInExistingDB, org.openide.util.NbBundle.getMessage(ImportVisualPanel1.class, "ImportVisualPanel1.rdbImportInExistingDB.text")); // NOI18N
      rdbImportInExistingDB.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            rdbImportInExistingDBActionPerformed(evt);
         }
      });

      jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
      org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ImportVisualPanel1.class, "ImportVisualPanel1.jLabel1.text")); // NOI18N

      jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
      org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ImportVisualPanel1.class, "ImportVisualPanel1.jLabel2.text")); // NOI18N

      txtDbName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
      txtDbName.setText(org.openide.util.NbBundle.getMessage(ImportVisualPanel1.class, "ImportVisualPanel1.txtDbName.text")); // NOI18N
      txtDbName.setEnabled(false);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(35, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(rdbCreateDbFromFDT)
               .addComponent(jLabel2)
               .addComponent(rdbImportAndCreateDB))
            .addGap(83, 83, 83))
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jSeparator1))
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                  .addGap(36, 36, 36)
                  .addComponent(rdbImportInExistingDB)
                  .addGap(18, 18, 18)
                  .addComponent(txtDbName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(22, Short.MAX_VALUE))
         .addGroup(layout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addComponent(jLabel1)
            .addContainerGap(367, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtDbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(rdbImportInExistingDB))
            .addGap(18, 18, 18)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel2)
            .addGap(33, 33, 33)
            .addComponent(rdbImportAndCreateDB)
            .addGap(18, 18, 18)
            .addComponent(rdbCreateDbFromFDT)
            .addContainerGap(59, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents

   private void rdbCreateDbFromFDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCreateDbFromFDTActionPerformed
      import_ = IMPORT_CREATE_DB_FROM_FDT;
      wizardDescriptor_.fireChangeEvent(); // Notify that the panel changed
}//GEN-LAST:event_rdbCreateDbFromFDTActionPerformed

   private void rdbImportAndCreateDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbImportAndCreateDBActionPerformed
      import_ = IMPORT_CREATE_EMPTY_DB;
      wizardDescriptor_.fireChangeEvent(); // Notify that the panel changed
}//GEN-LAST:event_rdbImportAndCreateDBActionPerformed

   private void rdbImportInExistingDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbImportInExistingDBActionPerformed
      import_ = IMPORT_IN_EXISTING_DB;
      wizardDescriptor_.fireChangeEvent(); // Notify that the panel changed
}//GEN-LAST:event_rdbImportInExistingDBActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.ButtonGroup buttonGroup1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JRadioButton rdbCreateDbFromFDT;
   private javax.swing.JRadioButton rdbImportAndCreateDB;
   private javax.swing.JRadioButton rdbImportInExistingDB;
   private javax.swing.JTextField txtDbName;
   // End of variables declaration//GEN-END:variables

   public int getImportType() {
        return import_;
    }
}

