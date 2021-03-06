package org.unesco.jisis.wizards.dbbackup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import org.openide.ErrorManager;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
final class dbRestoreTopComponent extends TopComponent {
    
    private static dbRestoreTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    
    private static final String PREFERRED_ID = "dbRestoreTopComponent";
    
    private dbRestoreTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(dbRestoreTopComponent.class, "CTL_dbRestoreTopComponent"));
        setToolTipText(NbBundle.getMessage(dbRestoreTopComponent.class, "HINT_dbRestoreTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jButton1 = new javax.swing.JButton();

      org.openide.awt.Mnemonics.setLocalizedText(jButton1, "rest");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(39, 39, 39)
            .addComponent(jButton1)
            .addContainerGap(303, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(66, 66, 66)
            .addComponent(jButton1)
            .addContainerGap(209, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents
    
    
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton1;
   // End of variables declaration//GEN-END:variables
    
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized dbRestoreTopComponent getDefault() {
        if (instance == null) {
            instance = new dbRestoreTopComponent();
        }
        return instance;
    }
    
    /**
     * Obtain the dbRestoreTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized dbRestoreTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find dbRestore component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof dbRestoreTopComponent) {
            return (dbRestoreTopComponent)win;
        }
        ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }
    
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }
    
    public void componentOpened() {
        // TODO add custom code on component opening
    }
    
    public void componentClosed() {
        // TODO add custom code on component closing
    }
    
    /** replaces this in object stream */
    public Object writeReplace() {
        return new ResolvableHelper();
    }
    
    protected String preferredID() {
        return PREFERRED_ID;
    }
    
    final static class ResolvableHelper implements Serializable {
        private static final long serialVersionUID = 1L;
        public Object readResolve() {
            return dbRestoreTopComponent.getDefault();
        }
    }
    
}
