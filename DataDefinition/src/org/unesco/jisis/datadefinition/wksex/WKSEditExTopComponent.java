/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unesco.jisis.datadefinition.wksex;

import java.awt.BorderLayout;
import java.util.MissingResourceException;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.ImageUtilities;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.unesco.jisis.corelib.client.ConnectionInfo;
import org.unesco.jisis.corelib.client.ConnectionPool;
import org.unesco.jisis.corelib.common.IDatabase;
import org.unesco.jisis.corelib.common.WorksheetDef;
import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.exceptions.GeneralDatabaseException;
import org.unesco.jisis.corelib.exceptions.ResourceNotFoundException;
import org.unesco.jisis.jisisutils.proxy.ClientDatabaseProxy;
import org.unesco.jisis.jisisutils.proxy.GuiGlobal;

/**
 * Top component which displays something.
 */

final class WKSEditExTopComponent extends TopComponent implements TableModelListener {

   private static WKSEditExTopComponent instance;
   /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
   /** path to the icon used by the component and its open action */
   static final String ICON_PATH = "org/unesco/jisis/datadefinition/wksex/wks.png";
   private static final String PREFERRED_ID = "WKSEditExTopComponent";
   private WKSVisualPanel wksVisualPanel_ = null;
   private ClientDatabaseProxy db_ = null;
   private String currentWksName_;
   private boolean wksChanged_ = false;


   public WKSEditExTopComponent(IDatabase db) {
      if (db instanceof ClientDatabaseProxy) {
         db_ = (ClientDatabaseProxy) db;
      } else {
         throw new RuntimeException("RecordDataBrowserTopComponent: Cannot cast DB to ClientDatabaseProxy");
      }
      /* Register this TopComponent as attached to this DB */
      db_.addWindow(this);

      initComponents();
      try {
         setName(NbBundle.getMessage(WKSEditExTopComponent.class, "CTL_WKSEditExTopComponent")
                 + " (" + db.getDbHome() + "//" + db.getDatabaseName() + ")");
      } catch (MissingResourceException ex) {
         new ResourceNotFoundException(ex).displayWarning();
      } catch (DbException ex) {
         new GeneralDatabaseException(ex).displayWarning();
      }
      setToolTipText(NbBundle.getMessage(WKSEditExTopComponent.class, "HINT_WKSEditExTopComponent"));

      setIcon(ImageUtilities.loadImage(ICON_PATH, true));

      try {
         String[] worksheetNames = db.getWorksheetNames();
         currentWksName_ = worksheetNames[0];

         cmbWorkSheets.setModel(new DefaultComboBoxModel(worksheetNames));
         wksVisualPanel_ = new WKSVisualPanel(db, cmbWorkSheets.getSelectedItem().toString());
         mainPanel.add(wksVisualPanel_, BorderLayout.CENTER);
      } catch (DbException ex) {
         new GeneralDatabaseException(ex).displayWarning();
      }
      wksChanged_ = false;
      btnSave.setEnabled(wksChanged_);
      wksVisualPanel_.getWKSModel().addTableModelListener((TableModelListener) this);

   }



   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      mainPanel = new javax.swing.JPanel();
      ctrlPanel = new javax.swing.JPanel();
      jToolBar1 = new javax.swing.JToolBar();
      wksLabel = new javax.swing.JLabel();
      cmbWorkSheets = new javax.swing.JComboBox();
      jSeparator6 = new javax.swing.JToolBar.Separator();
      btnNew = new javax.swing.JButton();
      jSeparator1 = new javax.swing.JToolBar.Separator();
      btnDel = new javax.swing.JButton();
      jSeparator2 = new javax.swing.JToolBar.Separator();
      btnSave = new javax.swing.JButton();
      jSeparator3 = new javax.swing.JToolBar.Separator();
      btnSaveAs = new javax.swing.JButton();
      jSeparator4 = new javax.swing.JToolBar.Separator();
      btnRestore = new javax.swing.JButton();
      jSeparator5 = new javax.swing.JToolBar.Separator();
      bntClose = new javax.swing.JButton();

      setLayout(new java.awt.BorderLayout());

      mainPanel.setLayout(new java.awt.BorderLayout());
      add(mainPanel, java.awt.BorderLayout.CENTER);

      jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
      jToolBar1.setFloatable(false);
      jToolBar1.setRollover(true);

      org.openide.awt.Mnemonics.setLocalizedText(wksLabel, org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.wksLabel.text")); // NOI18N
      jToolBar1.add(wksLabel);

      cmbWorkSheets.setToolTipText(org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.cmbWorkSheets.toolTipText")); // NOI18N
      cmbWorkSheets.setMaximumSize(new java.awt.Dimension(130, 18));
      cmbWorkSheets.setPreferredSize(new java.awt.Dimension(130, 20));
      cmbWorkSheets.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cmbWorkSheetsActionPerformed(evt);
         }
      });
      jToolBar1.add(cmbWorkSheets);
      jToolBar1.add(jSeparator6);

      org.openide.awt.Mnemonics.setLocalizedText(btnNew, org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.btnNew.text")); // NOI18N
      btnNew.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewActionPerformed(evt);
         }
      });
      jToolBar1.add(btnNew);
      jToolBar1.add(jSeparator1);

      org.openide.awt.Mnemonics.setLocalizedText(btnDel, org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.btnDel.text")); // NOI18N
      btnDel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDelActionPerformed(evt);
         }
      });
      jToolBar1.add(btnDel);
      jToolBar1.add(jSeparator2);

      org.openide.awt.Mnemonics.setLocalizedText(btnSave, org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.btnSave.text")); // NOI18N
      btnSave.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSaveActionPerformed(evt);
         }
      });
      jToolBar1.add(btnSave);
      jToolBar1.add(jSeparator3);

      org.openide.awt.Mnemonics.setLocalizedText(btnSaveAs, org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.btnSaveAs.text")); // NOI18N
      btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSaveAsActionPerformed(evt);
         }
      });
      jToolBar1.add(btnSaveAs);
      jToolBar1.add(jSeparator4);

      org.openide.awt.Mnemonics.setLocalizedText(btnRestore, org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.btnRestore.text")); // NOI18N
      btnRestore.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRestoreActionPerformed(evt);
         }
      });
      jToolBar1.add(btnRestore);
      jToolBar1.add(jSeparator5);

      org.openide.awt.Mnemonics.setLocalizedText(bntClose, org.openide.util.NbBundle.getMessage(WKSEditExTopComponent.class, "WKSEditExTopComponent.bntClose.text")); // NOI18N
      bntClose.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bntCloseActionPerformed(evt);
         }
      });
      jToolBar1.add(bntClose);

      javax.swing.GroupLayout ctrlPanelLayout = new javax.swing.GroupLayout(ctrlPanel);
      ctrlPanel.setLayout(ctrlPanelLayout);
      ctrlPanelLayout.setHorizontalGroup(
         ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(ctrlPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(406, Short.MAX_VALUE))
      );
      ctrlPanelLayout.setVerticalGroup(
         ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(ctrlPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      add(ctrlPanel, java.awt.BorderLayout.NORTH);
   }// </editor-fold>//GEN-END:initComponents

   private void cmbWorkSheetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbWorkSheetsActionPerformed
      wksVisualPanel_.load(db_, cmbWorkSheets.getSelectedItem().toString());
      wksChanged_ = false;
      btnSave.setEnabled(wksChanged_);
      wksVisualPanel_.getWKSModel().addTableModelListener((TableModelListener) this);
}//GEN-LAST:event_cmbWorkSheetsActionPerformed

   private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

      String label = NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_NewWKSLabel");
      String title = NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_NewWKSDialogTitle");

      checkWksSaved();
      NotifyDescriptor.InputLine d =
              new NotifyDescriptor.InputLine(label, title);
      if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.OK_OPTION) {
         String wksName = d.getInputText();
         if (wksNameExists(wksName)) {
            NotifyDescriptor nd =
                    new NotifyDescriptor.Message(NbBundle.
                    getMessage( WKSEditExTopComponent.class,"WKS_Name_Already_Exits"));
            DialogDisplayer.getDefault().notify(nd);
            return;
         }

         WorksheetDef wdf =  new WorksheetDef();

         try {
            /** Save the empty WKS on the server */
            wdf.setName(wksName);
            db_.saveWorksheetDef(wdf);

            /** Reload the list of format names from the server */

            String[] wksNames = db_.getWorksheetNames();
            /** Reset the model with the new list of format names */
            cmbWorkSheets.setModel(new DefaultComboBoxModel(wksNames));
            cmbWorkSheets.setSelectedItem(wksName);
            currentWksName_ = cmbWorkSheets.getSelectedItem().toString();

            wksVisualPanel_.load(db_,currentWksName_);
            wksChanged_ = false;
            btnSave.setEnabled(wksChanged_);
            wksVisualPanel_.getWKSModel().addTableModelListener((TableModelListener) this);

            //editorPane_.setText(currentPft_.getFormat());
         } catch (DbException ex) {
            new GeneralDatabaseException(ex).displayWarning();
         } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
         }
         setWksChanged(false);
         //        NotifyDescriptor.InputLine d =
         //                new NotifyDescriptor.InputLine(label, title);
         //        if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.OK_OPTION) {
         //            WorksheetDef wd = new WorksheetDef(d.getInputText());
         //            try {
         //                db_.saveWorksheetDef(wd);
         //                String[] worksheetNames = db_.getWorksheetNames();
         //                cmbWorkSheets.setModel(new DefaultComboBoxModel(worksheetNames));
         //            } catch (DbException ex) {
         //                new GeneralDatabaseException(ex).displayWarning();
         //            }
      }
}//GEN-LAST:event_btnNewActionPerformed

   private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

      String label = NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_DeleteWKSLabel");
      String title = NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_DeleteWKSDialogTitle");

      NotifyDescriptor d =
              new NotifyDescriptor.Confirmation(label, title,
              NotifyDescriptor.OK_CANCEL_OPTION);
      if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.OK_OPTION) {
         try {
            db_.removeWorksheetDef(cmbWorkSheets.getSelectedItem().toString());
            int i = cmbWorkSheets.getSelectedIndex();
            cmbWorkSheets.removeItemAt(i);

            String[] worksheetNames = db_.getWorksheetNames();
            cmbWorkSheets.setModel(new DefaultComboBoxModel(worksheetNames));
            cmbWorkSheets.setSelectedItem(0);
         } catch (DbException ex) {
            new GeneralDatabaseException(ex).displayWarning();
         }
      }


   }//GEN-LAST:event_btnDelActionPerformed

   private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
      wksVisualPanel_.load(db_, cmbWorkSheets.getSelectedItem().toString());
      wksChanged_ = false;
      btnSave.setEnabled(wksChanged_);
      wksVisualPanel_.getWKSModel().addTableModelListener((TableModelListener) this);
}//GEN-LAST:event_btnRestoreActionPerformed

   private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      try {
         WorksheetDef wdf = wksVisualPanel_.getWorksheetDef();
         wdf.setRecordValidationFormat(wksVisualPanel_.getRecordValFormat());
         db_.saveWorksheetDef(wdf);
         wksChanged_ = false;
         btnSave.setEnabled(wksChanged_);
         GuiGlobal.output(NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_WksSuccessfullySaved"));
      } catch (DbException ex) {
         new GeneralDatabaseException(ex).displayWarning();
      }
}//GEN-LAST:event_btnSaveActionPerformed

   private void bntCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCloseActionPerformed
      close();
}//GEN-LAST:event_bntCloseActionPerformed

   private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
      String label = NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_SaveAsWKSLabel");
      String title = NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_SaveAsWKSDialogTitle");

      String wksName = null;
      NotifyDescriptor.InputLine d =
              new NotifyDescriptor.InputLine(label, title);
      if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.OK_OPTION) {
         wksName = d.getInputText();
         if (wksNameExists(wksName)) {
            NotifyDescriptor nd =
                    new NotifyDescriptor.Message(NbBundle.getMessage(WKSEditExTopComponent.class, "WKS_Name_Already_Exits"));
            DialogDisplayer.getDefault().notify(nd);
            return;
         }



         try {
            /** Save the WKS with a new name on the server */
            WorksheetDef wdf = wksVisualPanel_.getWorksheetDef();
            wdf.setName(wksName);
            wdf.setRecordValidationFormat(wksVisualPanel_.getRecordValFormat());
            db_.saveWorksheetDef(wdf);
            wksChanged_ = false;
            btnSave.setEnabled(wksChanged_);
            GuiGlobal.output(NbBundle.getMessage(WKSEditExTopComponent.class, "MSG_WksSuccessfullySaved"));


            /** Reload the list of format names from the server */
            String[] wksNames = db_.getWorksheetNames();
            /** Reset the model with the new list of format names */
            cmbWorkSheets.setModel(new DefaultComboBoxModel(wksNames));
            cmbWorkSheets.setSelectedItem(wksName);
            currentWksName_ = cmbWorkSheets.getSelectedItem().toString();

            wksVisualPanel_.load(db_, currentWksName_);
            wksChanged_ = false;
            btnSave.setEnabled(wksChanged_);
            wksVisualPanel_.getWKSModel().addTableModelListener((TableModelListener) this);

            //editorPane_.setText(currentPft_.getFormat());
         } catch (DbException ex) {
            new GeneralDatabaseException(ex).displayWarning();
         } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
         }
         setWksChanged(false);
      }
   }//GEN-LAST:event_btnSaveAsActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton bntClose;
   private javax.swing.JButton btnDel;
   private javax.swing.JButton btnNew;
   private javax.swing.JButton btnRestore;
   private javax.swing.JButton btnSave;
   private javax.swing.JButton btnSaveAs;
   private javax.swing.JComboBox cmbWorkSheets;
   private javax.swing.JPanel ctrlPanel;
   private javax.swing.JToolBar.Separator jSeparator1;
   private javax.swing.JToolBar.Separator jSeparator2;
   private javax.swing.JToolBar.Separator jSeparator3;
   private javax.swing.JToolBar.Separator jSeparator4;
   private javax.swing.JToolBar.Separator jSeparator5;
   private javax.swing.JToolBar.Separator jSeparator6;
   private javax.swing.JToolBar jToolBar1;
   private javax.swing.JPanel mainPanel;
   private javax.swing.JLabel wksLabel;
   // End of variables declaration//GEN-END:variables
   /**
    * Gets default instance. Do not use directly: reserved for *.settings files only,
    * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
    * To obtain the singleton instance, use {@link #findInstance}.
    */
   public static synchronized WKSEditExTopComponent getDefault() {
      if (instance != null) {
            instance.close();
            instance = null;
        }
        ConnectionInfo connectionInfo = ConnectionPool.getDefaultConnectionInfo();
        if (connectionInfo.getDefaultDatabase() != null) {
            instance = new WKSEditExTopComponent(connectionInfo.getDefaultDatabase());
        }
        
        return instance;

   }

   /**
    * Obtain the WKSEditExTopComponent instance. Never call {@link #getDefault} directly!
    */
   public static synchronized WKSEditExTopComponent findInstance() {
      TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
      if (win == null) {
         Logger.getLogger(WKSEditExTopComponent.class.getName()).warning(
                 "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
         return getDefault();
      }
      if (win instanceof WKSEditExTopComponent) {
         return (WKSEditExTopComponent) win;
      }
      Logger.getLogger(WKSEditExTopComponent.class.getName()).warning(
              "There seem to be multiple components with the '" + PREFERRED_ID
              + "' ID. That is a potential source of errors and unexpected behavior.");
      return getDefault();
   }

   @Override
   public int getPersistenceType() {
      return TopComponent.PERSISTENCE_NEVER;
   }

   @Override
   public void componentOpened() {
      // TODO add custom code on component opening
   }

   @Override
   public void componentClosed() {

      db_.deleteWindow(this);
   }

   void writeProperties(java.util.Properties p) {
      // better to version settings since initial version as advocated at
      // http://wiki.apidesign.org/wiki/PropertyFiles
      p.setProperty("version", "1.0");
      // TODO store your settings
   }

   Object readProperties(java.util.Properties p) {
      if (instance == null) {
         instance = this;
      }
      instance.readPropertiesImpl(p);
      return instance;
   }

   private void readPropertiesImpl(java.util.Properties p) {
      String version = p.getProperty("version");
      // TODO read your settings according to their version
   }

   @Override
   protected String preferredID() {
      return PREFERRED_ID;
   }

    private boolean checkWksSaved() {

      if (wksChanged_) {
         NotifyDescriptor nd = new NotifyDescriptor.Confirmation(
                 "The Current FST was modified!\nDo you want to save it?",
                 NotifyDescriptor.YES_NO_CANCEL_OPTION,
                 NotifyDescriptor.QUESTION_MESSAGE);

         Object option = DialogDisplayer.getDefault().notify(nd);
         if (option == NotifyDescriptor.CANCEL_OPTION) {
            // Do nothing
            return false;

         } else if (option == NotifyDescriptor.YES_OPTION) {
            btnSaveActionPerformed(null);
         }
      }
      return true;
   }

     private boolean wksNameExists(String name) {
      try {
         String[] wksNames = db_.getWorksheetNames();
         for (int i = 0; i < wksNames.length; i++) {
            if (wksNames[i].equals(name)) {
               return true;
            }
         }
         return false;
      } catch (DbException ex) {
         Exceptions.printStackTrace(ex);
      }
      return false;
   }

      private void setWksChanged(boolean changed) {
      if (changed) {
         wksChanged_ = true;
         btnSave.setEnabled(wksChanged_);
//         try {
//            this.setDisplayName("FST Manager" + " (" + db_.getDatabaseName() + ")" + "*");
//         } catch (DbException ex) {
//            Exceptions.printStackTrace(ex);
//         }
      } else {
         wksChanged_ = false;
         btnSave.setEnabled(wksChanged_);
//         try {
//            this.setDisplayName("FST Manager" + " (" + db_.getDatabaseName() + ")");
//         } catch (DbException ex) {
//            Exceptions.printStackTrace(ex);
//         }
      }
   }

   public void tableChanged(TableModelEvent arg0) {
       setWksChanged(true);
   }
}
