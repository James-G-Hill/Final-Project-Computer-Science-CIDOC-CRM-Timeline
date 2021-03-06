package org.jghill.timelinevisualizerqueriescollection;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinevisualizerqueries.QueryShell;

/**
 * A collection for holding a set of AbstractQueries.
 * 
 * @author JGHill
 */
public class QueriesCollection implements Iterable<QueryShell> {
    
    private final SortedSet<QueryShell> collection;
    
    public QueriesCollection() {
        collection = new TreeSet<>();
    }
    
    /**
     * A method for adding new queries into the collection.
     * 
     * @param q A query.
     */
    public void addQuery(QueryShell q) {
        collection.add(q);
    }
    
    /**
     * Delete a query from the collection & return 'true' to confirm
     * 
     * @param query The query to be deleted.
     * @return confirmation that a query has been added.
     */
    public boolean deleteQuery(QueryShell query) {
        return collection.remove(query);
    }
    
    /**
     * Return the entire collection.
     * 
     * @return the query collection.
     */
    public SortedSet<QueryShell> getCollectionSet() {
        return collection;
    }
    
    /**
     * A method for returning a count of the queries in the collection.
     * 
     * @return the count of queries.
     */
    public int getCount() {
        return collection.size();
    }

    @Override
    public Iterator iterator() {
        return collection.iterator();
    }
    
    /**
     * Returns the collection as an array.
     * 
     * @return the collection in array form.
     */
    public QueryShell[] collectionToArray() {
        QueryShell[] queries = new QueryShell[collection.size()];
        queries = collection.toArray(queries);
        return queries;
    }
    
}