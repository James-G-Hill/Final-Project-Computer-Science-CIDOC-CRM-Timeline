package org.jghill.timelinesvisualizercollections;

import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;

/**
 * An interface for Collections.
 * 
 * @author JGHill
 */
public interface Collection {
    
    public String getName();
    
    public void setName(String name);
    
    public String getNotes();
    
    public void setNotes(String notes);
    
    public EntitiesCollection getEntitiesCollection();
    
    public QueriesCollection getQueriesCollection();
    
}