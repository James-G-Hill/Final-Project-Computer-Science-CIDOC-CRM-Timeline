package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.SPARQLEndpoint;
import org.jghill.timelinevisualizersources.SourceCollection;
import org.jghill.timelinevisualizersources.SourceTableModel;

/**
 * A dialog for adding new sources to the SourceCollection.
 * 
 * @author JGHill
 */
public class SourceManagementNew extends javax.swing.JDialog {

    /**
     * Creates new form SourceManagementNew
     */
    public SourceManagementNew(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SourceNameEntryBox = new javax.swing.JTextField();
        SourceNameText = new javax.swing.JLabel();
        SourceTypeText = new javax.swing.JLabel();
        NewSourceSelectionBox = new javax.swing.JComboBox<>();
        Create = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SourceManagementNew.class, "SourceManagementNew.title")); // NOI18N
        setAlwaysOnTop(true);
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("New Source Tool"); // NOI18N
        setResizable(false);

        SourceNameEntryBox.setText(org.openide.util.NbBundle.getMessage(SourceManagementNew.class, "SourceManagementNew.SourceNameEntryBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceNameText, org.openide.util.NbBundle.getMessage(SourceManagementNew.class, "SourceManagementNew.SourceNameText.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceTypeText, org.openide.util.NbBundle.getMessage(SourceManagementNew.class, "SourceManagementNew.SourceTypeText.text")); // NOI18N

        NewSourceSelectionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select....", "SPARQL Endpoint", "Text File" }));
        NewSourceSelectionBox.setMaximumSize(new java.awt.Dimension(150, 20));
        NewSourceSelectionBox.setMinimumSize(new java.awt.Dimension(150, 20));
        NewSourceSelectionBox.setPreferredSize(new java.awt.Dimension(150, 20));
        NewSourceSelectionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewSourceSelectionBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(Create, org.openide.util.NbBundle.getMessage(SourceManagementNew.class, "SourceManagementNew.Create.text")); // NOI18N
        Create.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Create.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SourceTypeText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SourceNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SourceNameEntryBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewSourceSelectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 230, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Create))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SourceNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SourceNameEntryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SourceTypeText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewSourceSelectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Create)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NewSourceSelectionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewSourceSelectionBoxActionPerformed
        removeInternalPanel();
        switch(NewSourceSelectionBox.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                addSPARQLEndpointDialog();
                break;
            case 2:
                break;
            default:
                break;
        }
    }//GEN-LAST:event_NewSourceSelectionBoxActionPerformed

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        
        String sourceName = SourceNameEntryBox.getText();
        if(!sourceName.isEmpty()) {
            switch(NewSourceSelectionBox.getSelectedIndex()) {
                case 0:
                    break;
                case 1:
                    createNewSPARQLEndpoint();
                    sourceTable.fireTableDataChanged();
                    this.dispose();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
        
    }//GEN-LAST:event_CreateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create;
    private javax.swing.JComboBox<String> NewSourceSelectionBox;
    private javax.swing.JTextField SourceNameEntryBox;
    private javax.swing.JLabel SourceNameText;
    private javax.swing.JLabel SourceTypeText;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private SPARQLEndpointPanel internalPanel;
    private SourceTableModel sourceTable;
    
    /**
     * A method for creating a new SPARQLEndpoint.
     */
    private void createNewSPARQLEndpoint() {
        String name = SourceNameEntryBox.getText();
        String webText = internalPanel.getText();
        if(NewSourceSelectionBox.getSelectedIndex() == 1 &&
                !webText.isEmpty()) {
            SPARQLEndpoint sparql = new SPARQLEndpoint(name, webText);
            SourceCollection collection = SourceCollection.getInstance();
            collection.addSource(sparql);
        }
    }
    
    /**
     * A method for adding options for a SPARQL endpoint.
     */
    private void addSPARQLEndpointDialog() {
        internalPanel = new SPARQLEndpointPanel();
        internalPanel.setSize(360, 120);
        internalPanel.setLocation(10, 120);
        this.add(internalPanel);
        validate();
        repaint();
    }
    
    /**
     * Remove any internal panel if it exists.
     */
    private void removeInternalPanel() {
        if(internalPanel != null) {
            this.remove(internalPanel);
            repaint();
        }
    }
    
    /**
     * A setter for a sourceTableModel to be updated by this class.
     * 
     * @param s the sourceTableModel to be added.
     */
    public void setSourceTableModel(SourceTableModel s) {
        sourceTable = s;
    }

}