package org.unesco.jisis.wizards.dbopen;

import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;
import org.openide.util.NbBundle;
import org.unesco.jisis.wizards.dbcreate.DbNamesModel;

public final class DbOpenVisualPanel2 extends JPanel {
    
    /** Creates new form DbOpenVisualPanel2 */
    public DbOpenVisualPanel2() {
        initComponents();
    }
    
   @Override
    public String getName() {
        return NbBundle.getMessage(DbOpenVisualPanel2.class, "MSG_DbOpenVisualPanel2");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      jList1 = new javax.swing.JList();

      org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DbOpenVisualPanel2.class, "LBL_SelDBNAME")); // NOI18N

      jScrollPane1.setViewportView(jList1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel1))
            .addContainerGap(126, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(50, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents
    
    
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel jLabel1;
   private javax.swing.JList jList1;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
    
    public void fillDbNames(List<String> dbNames) {
        jList1.setModel(new DbNamesModel(Collections.enumeration(dbNames)));
        jList1.setSelectedIndex(0); // Select the first database, if there is none, this will do nothing.
        jList1.updateUI();
    }

    String getDbName() {
        Object selObject = jList1.getSelectedValue();
        return (selObject == null ? "" : selObject.toString());
    }
}

