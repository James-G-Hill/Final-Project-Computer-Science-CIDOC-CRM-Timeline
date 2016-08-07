package org.jghill.timelinesvisualizercollections.node;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * A node for holding a Collection in the Viewer.
 * @author JGHill
 */
public class CollectionNode extends AbstractNode implements PropertyChangeListener {
    
    private Collection collection;
    private InstanceContent instanceContent;
    private final String displayName = "Collections";
    
    public CollectionNode(Collection coll) {
        this(coll, new InstanceContent());
    }
    
    public CollectionNode(Collection coll, InstanceContent ic) {
        super(Children.LEAF, new AbstractLookup(ic));
        this.collection = coll;
        this.instanceContent = ic;
        this.instanceContent.add(coll);
        setup();
    }
    
    public CollectionNode() {
        super(new CollectionChildren());
        setDisplayName(displayName);
    }
    
    private void setup() {
        setDisplayName(collection.getName());
        collection.addPropertyChangeListener(this);
    }
    
    @Override
    public boolean canDestroy() {
        return true;
    }
    
    @Override
    public Action[] getActions(boolean popup) {
        return new Action[] {
            new ViewerOpenAction(getLookup()),
            new ViewerDeleteAction(getLookup())
        };
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("name".equals(evt.getPropertyName())) {
            setDisplayName((String) evt.getNewValue());
            this.fireDisplayNameChange(null, getDisplayName());
        }
    }
    
}