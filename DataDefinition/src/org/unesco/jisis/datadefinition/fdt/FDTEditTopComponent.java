package org.unesco.jisis.datadefinition.fdt;

import java.awt.BorderLayout;
import java.util.MissingResourceException;
import java.util.Observable;
import java.util.Observer;

import org.openide.DialogDisplayer;
import org.openide.ErrorManager;
import org.openide.NotifyDescriptor;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.unesco.jisis.corelib.client.ConnectionInfo;
import org.unesco.jisis.corelib.client.ConnectionPool;
import org.unesco.jisis.corelib.common.FieldDefinitionTable;
import org.unesco.jisis.corelib.common.IDatabase;
import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.exceptions.DefaultDBNotFoundException;
import org.unesco.jisis.corelib.exceptions.GeneralDatabaseException;
import org.unesco.jisis.corelib.exceptions.ResourceNotFoundException;
import org.unesco.jisis.jisiscore.client.GuiGlobal;
import org.unesco.jisis.jisiscore.client.ClientDatabaseProxy;


/**
 * FDT Editor Top component
 * @author jc_dauphin
 */
final class FDTEditTopComponent extends TopComponent implements Observer {

   private static FDTEditTopComponent instance;
   /** path to the icon used by the component and its open action */
   static final String ICON_PATH = "org/unesco/jisis/datadefinition/fdt/fdt.png";
   private static final String PREFERRED_ID = "FDTEditTopComponent";
   private ClientDatabaseProxy db_ = null;
   private FDTVisualPanel fdtVisualPane_ = null;

   public FDTEditTopComponent(IDatabase db) {
      if (db instanceof ClientDatabaseProxy) {
         db_ = (ClientDatabaseProxy) db;
      } else {
         throw new RuntimeException("FDTEditTopComponent: Cannot cast DB to ClientDatabaseProxy");
      }
     
      initComponents();
      try {
         setName(NbBundle.getMessage(FDTEditTopComponent.class, "CTL_FDTEditTopComponent") 
                 + " (" +db.getDbHome()+"//"+ db.getDatabaseName() + ")");
      } catch (MissingResourceException ex) {
         new ResourceNotFoundException(ex).displayWarning();
      } catch (DbException ex) {
         new GeneralDatabaseException(ex).displayWarning();
      }
      setToolTipText(NbBundle.getMessage(FDTEditTopComponent.class, "HINT_FDTEditTopComponent"));
      setIcon(ImageUtilities.loadImage(ICON_PATH, true));
      fdtVisualPane_ = new FDTVisualPanel(db);
      fdtVisualPane_.addObserver((Observer) this);
      displayPanel.add(fdtVisualPane_, BorderLayout.CENTER);
      updateButtons();
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
        btnClose = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        ctrlPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ctrlPanel.setPreferredSize(new java.awt.Dimension(100, 40));

        org.openide.awt.Mnemonics.setLocalizedText(btnClose, org.openide.util.NbBundle.getMessage(FDTEditTopComponent.class, "BTN_Close")); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnRefresh, org.openide.util.NbBundle.getMessage(FDTEditTopComponent.class, "BTN_Refresh")); // NOI18N
        btnRefresh.setToolTipText("Restore FDT content from last saved operation");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnSave, org.openide.util.NbBundle.getMessage(FDTEditTopComponent.class, "BTN_Save")); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ctrlPanelLayout = new javax.swing.GroupLayout(ctrlPanel);
        ctrlPanel.setLayout(ctrlPanelLayout);
        ctrlPanelLayout.setHorizontalGroup(
            ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(578, Short.MAX_VALUE))
        );
        ctrlPanelLayout.setVerticalGroup(
            ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctrlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ctrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnRefresh)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        displayPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ctrlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ctrlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       try {
          FieldDefinitionTable fdt = fdtVisualPane_.getFDTModel().getFieldDefinitionTable();
          db_.saveFieldDefinitionTable(fdt);
          fdtVisualPane_.setFdtChanged(false);
          GuiGlobal.output(NbBundle.getMessage(FDTEditTopComponent.class, "MSG_FdtSuccessfullySaved"));
       } catch (DbException ex) {
          new GeneralDatabaseException(ex).displayWarning();
       }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       fdtVisualPane_.restore(db_);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
       if (canCloseFdt()) {
          close();
       }
    }//GEN-LAST:event_btnCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel ctrlPanel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

   /**
    * Gets default instance. Do not use directly: reserved for *.settings files only,
    * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
    * To obtain the singleton instance, use {@link findInstance}.
    */
   public static synchronized FDTEditTopComponent getDefault() throws DefaultDBNotFoundException {

      if (instance != null) {
         instance.close();
         instance = null;
      }

      ConnectionInfo connectionInfo = ConnectionPool.getDefaultConnectionInfo();
      if (connectionInfo.getDefaultDatabase() != null) {
         instance = new FDTEditTopComponent(connectionInfo.getDefaultDatabase());
      }

      return instance;
   }

   /**
    * Obtain the FDTEditTopComponent instance. Never call {@link #getDefault} directly!
    */
   public static synchronized FDTEditTopComponent findInstance() throws DefaultDBNotFoundException {
      TopComponent win = getDefault();

      if (win == null) {
         ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find FDTEdit component. It will not be located properly in the window system.");
         return getDefault();
      }
      if (win instanceof FDTEditTopComponent) {
         return (FDTEditTopComponent) win;
      }
      ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
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

   private boolean canCloseFdt() {

      if (fdtVisualPane_.isFdtChanged()) {
         NotifyDescriptor d = new NotifyDescriptor.Confirmation("FDT was modified but not saved!" + "\nDo you want really to close without saving?", "FDT Editor",
                 NotifyDescriptor.OK_CANCEL_OPTION, NotifyDescriptor.QUESTION_MESSAGE);
         if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.OK_OPTION) {

            return true;
         } else {
            return false;
         }
      }
      return true;
   }

   @Override
   public boolean canClose() {
      return canCloseFdt();

   }

   @Override
   public void componentClosed() {
      db_.deleteWindow(this);
   // TODO add custom code on component closing
   }

   /** replaces this in object stream */
   /*
   public Object writeReplace() {
   return new ResolvableHelper();
   }
    */
   @Override
   protected String preferredID() {
      return PREFERRED_ID;
   }
   /*
   final static class ResolvableHelper implements Serializable {
   private static final long serialVersionUID = 1L;
   public Object readResolve() {
   return FDTEditTopComponent.getDefault();
   }
   }
    */
   /* Update save button's state based off of the
   currently fdt modifications. */

   public void updateButtons() {
      if (fdtVisualPane_ != null) {
         if (fdtVisualPane_.isFdtChanged()) {
            btnSave.setEnabled(true);
            btnRefresh.setEnabled(true);
         } else {
            btnSave.setEnabled(false);
            btnRefresh.setEnabled(false);
         }
      }
   }

   public void update(Observable o, Object arg) {
      System.out.println("Observer update");
      updateButtons();
   }
}
