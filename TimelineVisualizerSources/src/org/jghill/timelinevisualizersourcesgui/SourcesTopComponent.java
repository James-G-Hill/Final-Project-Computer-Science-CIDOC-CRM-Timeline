package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.SourceCollection;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.jghill.timelinevisualizersources//Sources//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "SourcesTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "org.jghill.timelinevisualizersourcesgui.SourcesTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_SourcesAction",
        preferredID = "SourcesTopComponent"
)
@Messages({
    "CTL_SourcesAction=Sources",
    "CTL_SourcesTopComponent=Sources Window",
    "HINT_SourcesTopComponent=This is a Sources window"
})
public final class SourcesTopComponent extends TopComponent {

    public SourcesTopComponent() {
        initComponents();
        setName(Bundle.CTL_SourcesTopComponent());
        setToolTipText(Bundle.HINT_SourcesTopComponent());
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SourceManagementNewButton = new javax.swing.JButton();
        SourceManagementEditButton = new javax.swing.JButton();
        SourceManagementDeleteButton = new javax.swing.JButton();
        SourceManagementScrollPane = new javax.swing.JScrollPane();
        SourceManagementSourceTable = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("Source Management Tool"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceManagementNewButton, org.openide.util.NbBundle.getMessage(SourcesTopComponent.class, "SourcesTopComponent.SourceManagementNewButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceManagementEditButton, org.openide.util.NbBundle.getMessage(SourcesTopComponent.class, "SourcesTopComponent.SourceManagementEditButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceManagementDeleteButton, org.openide.util.NbBundle.getMessage(SourcesTopComponent.class, "SourcesTopComponent.SourceManagementDeleteButton.text")); // NOI18N

        SourceManagementScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SourceManagementScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SourceManagementScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SourceManagementScrollPane.setHorizontalScrollBar(null);
        SourceManagementScrollPane.setMaximumSize(new java.awt.Dimension(380, 140));
        SourceManagementScrollPane.setMinimumSize(new java.awt.Dimension(380, 140));
        SourceManagementScrollPane.setPreferredSize(new java.awt.Dimension(380, 140));

        SourceManagementSourceTable.setModel(new SourceTableModel(SourceCollection.getInstance()));
        SourceManagementSourceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        SourceManagementSourceTable.setMaximumSize(new java.awt.Dimension(380, 140));
        SourceManagementSourceTable.setMinimumSize(new java.awt.Dimension(380, 140));
        SourceManagementSourceTable.setPreferredSize(new java.awt.Dimension(380, 140));
        SourceManagementScrollPane.setViewportView(SourceManagementSourceTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SourceManagementNewButton)
                        .addGap(18, 18, 18)
                        .addComponent(SourceManagementEditButton)
                        .addGap(18, 18, 18)
                        .addComponent(SourceManagementDeleteButton))
                    .addComponent(SourceManagementScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SourceManagementScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SourceManagementNewButton)
                    .addComponent(SourceManagementEditButton)
                    .addComponent(SourceManagementDeleteButton))
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SourceManagementDeleteButton;
    private javax.swing.JButton SourceManagementEditButton;
    private javax.swing.JButton SourceManagementNewButton;
    private javax.swing.JScrollPane SourceManagementScrollPane;
    private javax.swing.JTable SourceManagementSourceTable;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}