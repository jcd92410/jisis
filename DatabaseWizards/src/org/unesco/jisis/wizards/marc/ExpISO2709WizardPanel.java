package org.unesco.jisis.wizards.marc;

import java.awt.Component;
import java.io.File;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

public class ExpISO2709WizardPanel implements WizardDescriptor.Panel {
    
    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private Component component;
    
    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    public Component getComponent() {
        if (component == null) {
            component = new ExpISO2709VisualPanel();
        }
        return component;
    }
    
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx(SampleWizardPanel1.class);
    }
    
    public boolean isValid() {
       


        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...), then:
        // return someCondition();
        // and when this condition changes (last form field filled in...) then:
        // fireChangeEvent();
        // and uncomment the complicated stuff below.
    }
    
    public final void addChangeListener(ChangeListener l) {}
    public final void removeChangeListener(ChangeListener l) {}
    /*
    private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1);
    public final void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }
    public final void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }
    protected final void fireChangeEvent() {
        Iterator<ChangeListener> it;
        synchronized (listeners) {
            it = new HashSet<ChangeListener>(listeners).iterator();
        }
        ChangeEvent ev = new ChangeEvent(this);
        while (it.hasNext()) {
            it.next().stateChanged(ev);
        }
    }
     */
    
    // You can use a settings object to keep track of state. Normally the
    // settings object will be the WizardDescriptor, so you can use
    // WizardDescriptor.getProperty & putProperty to store information entered
    // by the user.
    public void readSettings(Object settings) {}
    
    public void storeSettings(Object settings) {
        WizardDescriptor wd = (WizardDescriptor) settings;
        ExpISO2709VisualPanel panel = (ExpISO2709VisualPanel) getComponent();
        
        File file = new File(panel.getSelectedFile());

        wd.putProperty("selectedFile", file);


        String isoFile = panel.getSelectedFile();

        int mfnSelectionOption = panel.getMfnsRangeOption();
        String mfnRanges       = panel.getMfnRanges();
        int outputLineLength   = panel.getOutputLineLength();
        String reformattingFST = panel.getReformattingFST();
        int renumberFromMFN    = panel.getRenumberFromMFN();
        int outputTagMFN       = panel.getOutputTagMFN();
        int searchHistoryIndex = panel.getSearchHistoryIndex();
        int markedHistoryIndex = panel.getMarkedRecordsIndex();

       String encoding = panel.getEncoding();
      
        

        int fieldTerminator    = panel.getFieldTerminator();
        int recordTerminator   = panel.getRecordTerminator();
        int subfieldDelimiter  = panel.getSubfieldDelimiter();

        wd.putProperty("isoFile", isoFile);
        wd.putProperty("mfnRanges", mfnRanges);
        wd.putProperty("mfnSelectionOption", mfnSelectionOption);
        wd.putProperty("searchHistoryIndex", searchHistoryIndex);
        wd.putProperty("markedHistoryIndex", markedHistoryIndex);
        
        wd.putProperty("outputLineLength", outputLineLength);
        wd.putProperty("reformattingFST", reformattingFST);
        wd.putProperty("renumberFromMFN", renumberFromMFN);
        wd.putProperty("outputTagMFN", outputTagMFN);
        wd.putProperty("encoding", encoding);

        wd.putProperty("fieldTerminator", fieldTerminator);
        wd.putProperty("recordTerminator", recordTerminator);
        wd.putProperty("subfieldDelimiter", subfieldDelimiter);
    }




    
}

