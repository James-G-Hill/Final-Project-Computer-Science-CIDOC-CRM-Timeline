package org.jghill.timelinevisualizerviewergui;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.BeanTreeView;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Viewer for the manipulation of Collections.
 */
@ConvertAsProperties(
        dtd = "-//org.jghill.timelinesvisualizercollectionsgui//CollectionViewer//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "CollectionViewerTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.jghill.timelinesvisualizercollectionsgui.CollectionViewerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CollectionViewerAction",
        preferredID = "CollectionViewerTopComponent"
)
@Messages({
    "CTL_CollectionViewerAction=Collection Viewer",
    "CTL_CollectionViewerTopComponent=Collection Viewer",
    "HINT_CollectionViewerTopComponent=This is a Collection Viewer"
})
public final class ViewerTopComponent extends TopComponent implements ExplorerManager.Provider {

    private final transient ExplorerManager explorerManager = new ExplorerManager();
    //private final TreeTableView treeView;
    
    public ViewerTopComponent() {
        initComponents();
        setName(Bundle.CTL_CollectionViewerTopComponent());
        setToolTipText(Bundle.HINT_CollectionViewerTopComponent());
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        
        //associateLookup(ExplorerUtils.createLookup(explorerManager, getActionMap()));
        //explorerManager.getRootContext().setDisplayName("Your Collections");
        
//        treeView = new TreeTableView();
//        add(treeView);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewerScrollPane = new BeanTreeView();

        setPreferredSize(new java.awt.Dimension(200, 500));

        ViewerScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ViewerScrollPane.setHorizontalScrollBar(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewerScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ViewerScrollPane;
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

    @Override
    public ExplorerManager getExplorerManager() {
        return explorerManager;
    }
    
}