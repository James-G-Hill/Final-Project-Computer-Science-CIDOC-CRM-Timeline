package org.jghill.timelinevisualizer.properties;

import java.util.Collection;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;

/**
 * A viewer for displaying properties of the currently selected Entity.
 */
@ConvertAsProperties(
        dtd = "-//org.jghill.timelinevisualizer.properties//Properties//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "PropertiesTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "properties", openAtStartup = true)
@ActionID(category = "Window", id = "org.jghill.timelinevisualizer.properties.PropertiesTopComponent")
//@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_PropertiesAction",
        preferredID = "PropertiesTopComponent"
)
@Messages({
    "CTL_PropertiesAction=Properties",
    "CTL_PropertiesTopComponent=Properties",
    "HINT_PropertiesTopComponent=This is a Properties window"
})
public final class PropertiesTopComponent extends TopComponent implements LookupListener {

    public PropertiesTopComponent() {
        initComponents();
        setName(Bundle.CTL_PropertiesTopComponent());
        setToolTipText(Bundle.HINT_PropertiesTopComponent());
        
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        
        setup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IdentifierLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        SourceLabel = new javax.swing.JLabel();
        QueryLabel = new javax.swing.JLabel();
        IdentifierTextField = new javax.swing.JTextField();
        NameTextField = new javax.swing.JTextField();
        SourceTextField = new javax.swing.JTextField();
        QueryTextField = new javax.swing.JTextField();
        CreationYearTextField = new javax.swing.JTextField();
        CreationYearLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(300, 600));

        org.openide.awt.Mnemonics.setLocalizedText(IdentifierLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.IdentifierLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(NameLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.NameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.SourceLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(QueryLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.QueryLabel.text")); // NOI18N

        IdentifierTextField.setEditable(false);
        IdentifierTextField.setBackground(new java.awt.Color(255, 255, 255));
        IdentifierTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.IdentifierTextField.text")); // NOI18N

        NameTextField.setEditable(false);
        NameTextField.setBackground(new java.awt.Color(255, 255, 255));
        NameTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.NameTextField.text")); // NOI18N

        SourceTextField.setEditable(false);
        SourceTextField.setBackground(new java.awt.Color(255, 255, 255));
        SourceTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.SourceTextField.text")); // NOI18N

        QueryTextField.setEditable(false);
        QueryTextField.setBackground(new java.awt.Color(255, 255, 255));
        QueryTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.QueryTextField.text")); // NOI18N

        CreationYearTextField.setEditable(false);
        CreationYearTextField.setBackground(new java.awt.Color(255, 255, 255));
        CreationYearTextField.setText(org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.CreationYearTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CreationYearLabel, org.openide.util.NbBundle.getMessage(PropertiesTopComponent.class, "PropertiesTopComponent.CreationYearLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IdentifierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SourceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QueryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreationYearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdentifierTextField)
                    .addComponent(NameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(SourceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(QueryTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreationYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdentifierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdentifierTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SourceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SourceTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QueryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QueryTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreationYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreationYearTextField))
                .addContainerGap(450, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreationYearLabel;
    private javax.swing.JTextField CreationYearTextField;
    private javax.swing.JLabel IdentifierLabel;
    private javax.swing.JTextField IdentifierTextField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JLabel QueryLabel;
    private javax.swing.JTextField QueryTextField;
    private javax.swing.JLabel SourceLabel;
    private javax.swing.JTextField SourceTextField;
    // End of variables declaration//GEN-END:variables
    
    private Lookup.Result<ManMadeObject> result = null;
    
    private void setup() {
        result = Utilities.actionsGlobalContext().lookupResult(ManMadeObject.class);
        result.addLookupListener(this);
    }
    
    @Override
    public void componentOpened() {}

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
    }
    
    @Override
    public void resultChanged(LookupEvent lookupEvent) {
        Collection<? extends ManMadeObject> allEntities = result.allInstances();
        if (allEntities.size() == 1) {
            ManMadeObject entity = allEntities.iterator().next();
            IdentifierTextField.setText(entity.getIdentifier());
            NameTextField.setText(entity.getName());
            QueryTextField.setText(entity.getQueryName());
            SourceTextField.setText(entity.getSourceName());
            CreationYearTextField.setText(entity.getTimeSpan().toString());
        }
    }
    

    void writeProperties(java.util.Properties p) {
        p.setProperty("version", "1.0");
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
    }
    
}
