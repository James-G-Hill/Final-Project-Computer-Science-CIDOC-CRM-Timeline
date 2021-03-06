package org.jghill.timelinevisualizersources;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.jghill.timelinevisualizersourcesxml.SourceManagerXMLParser;
import org.jghill.timelinevisualizersourcesxml.SourceManagerXMLParserImpl;
import org.jghill.timelinevisualizersourcesxml.SourceManagerXMLWriter;
import org.jghill.timelinevisualizersourcesxml.SourceManagerXMLWriterImpl;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.xml.sax.SAXException;

/**
 * A singleton pattern holding a collections of sources.
 * 
 * @author JGHill
 */
public class SourceCollection implements Lookup.Provider {
    
    private static final SortedSet<Source> SOURCES = new TreeSet<>();
    private static final SourceCollection COLLECTION = new SourceCollection();
    private static final InstanceContent IC = new InstanceContent();
    private static final Lookup LOOKUP = new AbstractLookup(IC);
    
    private static SourceManagerXMLWriter xmlWriter;
    
    public static boolean loaded = false;
    
    /**
     * Returns the single instance of this singleton pattern.
     * 
     * @return this SourceCollection.
     */
    public static SourceCollection getInstance() {
        if (!loaded) {loadXML();}
        return COLLECTION;
    }
    
    /**
     * Return the entire collection.
     * 
     * @return the source collection.
     */
    public static SortedSet<Source> getSourceCollectionSet() {
        return SOURCES;
    }
    
    /**
     * Add a source to the collection.
     * 
     * @param source The new source to be added.
     */
    public static void addSource(Source source) {
        SOURCES.add(source);
        IC.add(source);
        saveXML();
    }
    
    /**
     * Delete a source from the collection & return 'true' to confirm.
     * 
     * @param source The source to be deleted.
     */
    public static void deleteSource(Source source) {
        SOURCES.remove(source);
        IC.remove(source);
        saveXML();
    }
    
    /**
     * Get a Source from a name.
     * 
     * @param name of the Source.
     * @return the Source.
     */
    public static Source getSource(String name) {
        Source source = null;
        for (Source s : SOURCES) {
            if (s.getSourceName().equalsIgnoreCase(name)) {
                source = s;
            }
        }
        return source;
    }
    
    /**
     * Returns the number of sources in the SourceCollection.
     * 
     * @return the size of the collection.
     */
    public static int getSize() {
        return SOURCES.size();
    }
    
    /**
     * Returns the collection as an array.
     * 
     * @return the collection in array form.
     */
    public static Source[] collectionToArray() {
        Source[] sources = new Source[SOURCES.size()];
        sources = SOURCES.toArray(sources);
        return sources;
    }
    
    /**
     * Returns a ComboBox based on the existing Sources.
     * 
     * @return the ComboBox.
     */
    public static ComboBoxModel getSourceComboBoxModel() {
        if (!loaded) {loadXML();}
        List<String> sources = new ArrayList<>();
        sources.add("Select . . .");
        for (Source source : SOURCES.toArray(new Source[0])) {
            sources.add(source.getSourceName());
        }
        return new DefaultComboBoxModel(sources.toArray(new String[0]));
    }
    
    @Override
    public Lookup getLookup() {
        return LOOKUP;
    }
    
    /**
     * Saves the Source Collection as an XML document.
     */
    private static void saveXML() {
        try {
            xmlWriter = new SourceManagerXMLWriterImpl();
            xmlWriter.build();
            xmlWriter.print();
        } catch (ParserConfigurationException ex) {}
    }
    
    /**
     * Loads the Sources from an XML file.
     */
    private static void loadXML() {
        File f = new File("Data/Source Manager/Source Manager.xml");
        if (f.exists()) {
            try {
                SourceManagerXMLParser parser;
                parser = new SourceManagerXMLParserImpl(f);
                List<Source> sources = parser.parseSources();
                sources.stream().forEach(SourceCollection::addSource);
                loaded = true;
            } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
    
}