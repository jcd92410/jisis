/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConvertDlg.java
 *
 * Created on Mar 16, 2009, 12:55:51 PM
 */

package org.unesco.jisis.FmtManager;

/**
 *
 * @author jc_dauphin
 */
public class ConvertDlg extends javax.swing.JDialog {

    protected String encoding_ = null;
    protected boolean succeeded_ = false;
    /** Creates new form ConvertDlg */
    public ConvertDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      lblEncoding = new javax.swing.JLabel();
      cmbEncoding = new javax.swing.JComboBox();
      jLabel1 = new javax.swing.JLabel();
      btnOK = new javax.swing.JButton();
      btnCancel = new javax.swing.JButton();
      jLabel2 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle(org.openide.util.NbBundle.getMessage(ConvertDlg.class, "ConvertDlg.title")); // NOI18N

      lblEncoding.setFont(new java.awt.Font("Tahoma", 1, 11));
      lblEncoding.setText(org.openide.util.NbBundle.getMessage(ConvertDlg.class, "ConvertDlg.lblEncoding.text")); // NOI18N

      cmbEncoding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "US-ASCII", "CP850 (or IBM850)", "ISO-8859-1", "UTF-8", "UTF-16", "UTF-16BE", "UTF-16LE", "CP864 Arabic  (IBM PC)", "CP1256 Arabic Windows" }));
      cmbEncoding.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbEncodingActionPerformed(evt);
         }
      });

      jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 102, 255));
      jLabel1.setText(org.openide.util.NbBundle.getMessage(ConvertDlg.class, "ConvertDlg.jLabel1.text")); // NOI18N

      btnOK.setText(org.openide.util.NbBundle.getMessage(ConvertDlg.class, "ConvertDlg.btnOK.text")); // NOI18N
      btnOK.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnOKActionPerformed(evt);
         }
      });

      btnCancel.setText(org.openide.util.NbBundle.getMessage(ConvertDlg.class, "ConvertDlg.btnCancel.text")); // NOI18N
      btnCancel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
         }
      });

      jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(102, 102, 255));
      jLabel2.setText(org.openide.util.NbBundle.getMessage(ConvertDlg.class, "ConvertDlg.jLabel2.text")); // NOI18N

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1)
               .addComponent(jLabel2)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(btnOK)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                     .addComponent(btnCancel))
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(lblEncoding)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(cmbEncoding, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(41, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(cmbEncoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblEncoding))
            .addGap(35, 35, 35)
            .addComponent(jLabel2)
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnOK)
               .addComponent(btnCancel))
            .addContainerGap(19, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void cmbEncodingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEncodingActionPerformed
       // TODO add your handling code here:
}//GEN-LAST:event_cmbEncodingActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       // TODO add your handling code here:
       succeeded_ = false;
        dispose();
}//GEN-LAST:event_btnCancelActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
       // TODO add your handling code here:
       succeeded_ = true;
       dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    public boolean succeeded() {
      return succeeded_;
   }

   public String getEncoding() {
       String encoding = (String) cmbEncoding.getSelectedItem();
        if (encoding.startsWith("CP850"))
            encoding = "IBM850";
        else if (encoding.startsWith("CP864"))
            encoding = "Cp864";
          else if (encoding.startsWith("CP1256"))
            encoding = "Cp1256";
        return encoding;
     
   }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConvertDlg dialog = new ConvertDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnCancel;
   private javax.swing.JButton btnOK;
   private javax.swing.JComboBox cmbEncoding;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel lblEncoding;
   // End of variables declaration//GEN-END:variables

}