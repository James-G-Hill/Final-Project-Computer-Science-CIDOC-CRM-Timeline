package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.SourceCollection;
import org.jghill.timelinevisualizersources.SourceTableModel;

/**
 * A dialog box for managing sources.
 * 
 * @author JGHill
 */
public class SourceManagementTool extends javax.swing.JDialog {

    /**
     * Creates new form SourceManagementTool
     */
    public SourceManagementTool(java.awt.Frame parent, boolean modal) {
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

        SourceManagementNewButton = new javax.swing.JButton();
        SourceManagementEditButton = new javax.swing.JButton();
        SourceManagementDeleteButton = new javax.swing.JButton();
        SourceManagementScrollPane = new javax.swing.JScrollPane();
        SourceManagementSourceTable = new javax.swing.JTable();
        SourceManagementCloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SourceManagementTool.class, "SourceManagementTool.title")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(400, 200));
        setMinimumSize(new java.awt.Dimension(400, 200));
        setName("Source Management Tool"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 200));
        setResizable(false);

        org.openide.awt.Mnemonics.setLocalizedText(SourceManagementNewButton, org.openide.util.NbBundle.getMessage(SourceManagementTool.class, "SourceManagementTool.SourceManagementNewButton.text")); // NOI18N
        SourceManagementNewButton.setToolTipText(org.openide.util.NbBundle.getMessage(SourceManagementTool.class, "SourceManagementTool.SourceManagementNewButton.toolTipText")); // NOI18N
        SourceManagementNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceManagementNewButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(SourceManagementEditButton, org.openide.util.NbBundle.getMessage(SourceManagementTool.class, "SourceManagementTool.SourceManagementEditButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SourceManagementDeleteButton, org.openide.util.NbBundle.getMessage(SourceManagementTool.class, "SourceManagementTool.SourceManagementDeleteButton.text")); // NOI18N
        SourceManagementDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceManagementDeleteButtonActionPerformed(evt);
            }
        });

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

        org.openide.awt.Mnemonics.setLocalizedText(SourceManagementCloseButton, org.openide.util.NbBundle.getMessage(SourceManagementTool.class, "SourceManagementTool.SourceManagementCloseButton.text")); // NOI18N
        SourceManagementCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceManagementCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SourceManagementScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SourceManagementNewButton)
                        .addGap(18, 18, 18)
                        .addComponent(SourceManagementEditButton)
                        .addGap(18, 18, 18)
                        .addComponent(SourceManagementDeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SourceManagementCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                    .addComponent(SourceManagementDeleteButton)
                    .addComponent(SourceManagementCloseButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 235));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SourceManagementNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceManagementNewButtonActionPerformed
        SourceManagementNew s;
        s = new SourceManagementNew(new javax.swing.JFrame(), true);
        s.setSourceTableModel((SourceTableModel) SourceManagementSourceTable.getModel());
        s.setVisible(true);
    }//GEN-LAST:event_SourceManagementNewButtonActionPerformed

    private void SourceManagementDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceManagementDeleteButtonActionPerformed
        int row = SourceManagementSourceTable.getSelectedRow();
        if(row != -1) {
            SourceTableModel s = (SourceTableModel)SourceManagementSourceTable.getModel();
            s.deleteSource(row);
        }
    }//GEN-LAST:event_SourceManagementDeleteButtonActionPerformed

    private void SourceManagementCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceManagementCloseButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_SourceManagementCloseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SourceManagementCloseButton;
    private javax.swing.JButton SourceManagementDeleteButton;
    private javax.swing.JButton SourceManagementEditButton;
    private javax.swing.JButton SourceManagementNewButton;
    private javax.swing.JScrollPane SourceManagementScrollPane;
    private javax.swing.JTable SourceManagementSourceTable;
    // End of variables declaration//GEN-END:variables
}