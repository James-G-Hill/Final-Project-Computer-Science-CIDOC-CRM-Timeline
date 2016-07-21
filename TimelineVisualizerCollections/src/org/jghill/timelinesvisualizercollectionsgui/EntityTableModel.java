package org.jghill.timelinesvisualizercollectionsgui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A model for assisting display of Entities in the Entity Table.
 * 
 * @author JGHill
 */
public class EntityTableModel extends AbstractTableModel {

    private final EntitiesCollection entitiesCollection;
    private Entities[] entities;
    
    private static final int COL_COUNT = 2;
    
    public EntityTableModel(EntitiesCollection entities) {
        this.entitiesCollection = entities;
        updateDataTable();
    }
    
    @Override
    public int getRowCount() {
        return entities.length;
    }

    @Override
    public int getColumnCount() {
        return COL_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return entities[rowIndex].getName();
            case 1:
                return entities[rowIndex].getName();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0:
                return "identifier";
            case 1:
                return "name";
            default:
                return null;
        }
    }
    
    @Override
    public void fireTableDataChanged() {
        updateDataTable();
        super.fireTableDataChanged();
    }
    
    /**
     * Updates the array fed from the data table.
     */
    private void updateDataTable() {
        List flat = entitiesFlatten(entitiesCollection);
        entities = (Entities[]) flat.toArray(new Entities[flat.size()]);
    }
    
    /**
     * Returns an entity from the underlying collection.
     * 
     * @param index the row number identifying the Entities.
     * @return The entity at the row.
     */
    public Entities returnQuery(int index) {
        return entities[index];
    }
    
    /**
     * Flattens the entities collection into a single list.
     * 
     * @param coll the EntitiesCollection.
     * @return a list containing all internal non collections.
     */
    private List<Entities> entitiesFlatten(EntitiesCollection coll) {
        List<Entities> arr = new ArrayList<>();
        for (Entities e : coll.getCollectionSet()) {
            if(e.getClass() == EntitiesCollection.class) {
                arr.addAll(entitiesFlatten((EntitiesCollection)e));
            } else {
                arr.add(e);
            }
        }
        return arr;
    }
    
}