package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Comparator.comparingInt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * Filters a collection of objects to a set of TimeLines.
 * 
 * @author JGHill
 */
public class TimeLineCollection {
    
    private static final List<Color> COLORS = Colours.getColours();
    
    private final String none = "None";
    private final String query = "Query";
    private final String source = "Source";
    private final String depicts = "Depicts";
    private final String material = "Material";
    private final String type = "Type";
    private final String technique = "Technique";
    private final String creator = "Creator";
    
    private final int MAX_CATEGORIES = 4;
    
    private final CollectionDisplayPanel cdp;
    
    private TimeLine[] timeLines;
    
    private final TreeMap<String, TreeMap<String, Integer>> filters;
    private TreeMap<String, TreeMap<String, Integer>> filterList;
    
    /**
     * Constructor.
     */
    public TimeLineCollection(CollectionDisplayPanel cdp) {
        this.cdp = cdp;
        filters = new TreeMap<>();
    }
    
    /**
     * Selects the filters that will be used to fill the ComboBox.
     * 
     * @param collection of objects.
     */
    public void createFilters(ManMadeObject[] collection) {
        
        createInitialFilter();
        for (ManMadeObject object: collection) {
            if (object.getTimeSpan() != null) {
                
                addToFilter(object.getQueryName(), query);
                addToFilter(object.getSourceName(), source);
                addToFilter(object.getDepicts(), depicts);
                addToFilter(object.getConsists(), material);
                addToFilter(object.getType(), type);
                addToFilter(object.getTechnique(), technique);
                addToFilter(object.getCreator(), creator);
                
            }
        }
        
        filterList = new TreeMap<>();
        filterList.put(none, new TreeMap<>());
        filters.forEach((k, v) -> {
            if (v.size() > 1) {
                filterList.put(k, v);
            }
        });
        
    }
    
    /**
     * Adds a dimension and adds to the count if the dimension already has been
     * entered.
     * 
     * @param objectDimension
     * @param filterName 
     */
    private void addToFilter(
            String objectDimension,
            String filterName
    ) {
        if (!filters.get(filterName).containsKey(objectDimension)) {
            filters.get(filterName).put(
                objectDimension,
                1
            );
        } else {
            filters.get(filterName).put(
                objectDimension,
                filters.get(filterName).get(objectDimension) + 1
            );
        }
    }
    
    
    /**
     * Chooses the option to filter the results by.
     * 
     * @return the option.
     */
    public String chooseFilter() {
        
        String choice = "None";
        int maxScore = 0;
        
        for (Map.Entry<String, TreeMap<String, Integer>> entry : filterList.entrySet()) {
            int tempScore = 1;
            for (Map.Entry<String, Integer> dimension : entry.getValue().entrySet()) {
                tempScore = (tempScore * dimension.getValue());
            }
            tempScore = tempScore * Math.min(
                    MAX_CATEGORIES - 1,
                    entry.getValue().entrySet().size()
            );
            if (entry.getKey().equalsIgnoreCase(query) ||
                        entry.getKey().equalsIgnoreCase(source)) {
                            int penalty = 2;
                            tempScore = tempScore / penalty;
            }
            if (tempScore > maxScore) {
                choice = entry.getKey();
                maxScore = tempScore;
            }
        }
                
        return choice;
        
    }
        
    /**
     * Create TimeLines from a set of objects.
     * 
     * @param collection of objects.
     * @return an array of TimeLines.
     */
    public void createTimeLines(
            ManMadeObject[] collection,
            String filter
    ) {
        Collections.shuffle(COLORS);
        runFilter(collection, filter);
    }
    
    /**
     * Filters the results.
     */
    private void runFilter(
            ManMadeObject[] collection,
            String filter
    ) {
        Map<String, List<ManMadeObject>> categories = new TreeMap<>();
        
        for (ManMadeObject object: collection) {
            if (object.getTimeSpan() != null) {
                String result;
                switch(filter) {
                    case query :
                        result = object.getQueryName();
                        break;
                    case source :
                        result = object.getSourceName();
                        break;
                    case depicts :
                        result = object.getDepicts();
                        break;
                    case material :
                        result = object.getConsists();
                        break;
                    case type :
                        result = object.getType();
                        break;
                    case technique :
                        result = object.getTechnique();
                        break;
                    case creator :
                        result = object.getCreator();
                        break;
                    case none :
                        result = "General";
                        break;
                    default :
                        result = "General";
                        break;
                }
                
                if (!result.equalsIgnoreCase("")) {
                    List<ManMadeObject> list;
                    if (categories.containsKey(result)) {
                        list = categories.get(result);
                        list.add(object);
                    } else {
                        list = new ArrayList<>();
                        list.add(object);
                        categories.putIfAbsent(result, list);
                    }
                } else {
                    List<ManMadeObject> list;
                    if (categories.containsKey("Blank")) {
                        list = categories.get("Blank");
                        list.add(object);
                    } else {
                        list = new ArrayList<>();
                        list.add(object);
                        categories.putIfAbsent("Blank", list);
                    }
                }
                
            }
        }
        
        timeLines = createTimeLineArray(categories);
        categories = sortCategories(categories);
        assignTimeLines(categories);
        
    }
    
    /**
     * Creates a TimeLine array based on the number of categories, capping the
     * number if it is over 4.
     * 
     * @param categories
     * @return an array of TimeLines.
     */
    private TimeLine[] createTimeLineArray(
            Map<String, List<ManMadeObject>> categories
    ) {
        TimeLine[] timeline;
        int categoriesCount = categories.size();
        if (categoriesCount <= MAX_CATEGORIES) {
            timeline = new TimeLine[categoriesCount];
        } else {
            timeline = new TimeLine[MAX_CATEGORIES];
        }
        return timeline;
    }
    
    /**
     * Sorts the TimeLines by their length.
     * 
     * @param categories a list of categories.
     * @return a sorted TreeMap of categories.
     */
    private Map<String, List<ManMadeObject>> sortCategories(
            Map<String, List<ManMadeObject>> categories
    ) {
        Map<String, List<ManMadeObject>> sorted;
        sorted = categories.entrySet().stream()
                .sorted(comparingByValue(comparingInt((List list) -> list.size()).reversed()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
        return sorted;
    }
    
    /**
     * Creates all TimeLines from the passed categories.
     * 
     * @param categories that can be passed into TimeLines.
     */
    private void assignTimeLines(
            Map<String, List<ManMadeObject>> categories
    ) {    
        int count = 0;
        ArrayList<ManMadeObject> other = new ArrayList<>();
        
        for (Map.Entry<String, List<ManMadeObject>> entry: categories.entrySet()) {
            if (count < MAX_CATEGORIES - 1) {
                timeLines[count] = new TimeLine(
                        entry.getKey(),
                        entry.getValue().toArray(new ManMadeObject[entry.getValue().size()]),
                        COLORS.get(count),
                        cdp
                );
                count++;
            } else {
                other.addAll(entry.getValue());
            }
        }
        
        if (count >= (MAX_CATEGORIES - 1) && !other.isEmpty()) {
            timeLines[MAX_CATEGORIES - 1] = new TimeLine(
                    "Other",
                    other.toArray(new ManMadeObject[0]),
                    COLORS.get(count),
                    cdp
            );
        }
        
    }
    
    /**
     * Returns the man made objects associated with the given name.
     * 
     * @param timelineName the name of the TimeLine to return objects from.
     * @return the objects associated with the TimeLine.
     */
    public ManMadeObject[] getTimeLineObjects(String timelineName) {
        ManMadeObject[] objects = null;
        if (timelineName.equalsIgnoreCase("None")) {
            objects = getAllTimeLineObjects();
        } else {
            for (TimeLine timeline : timeLines) {
                if (timeline.getName().equalsIgnoreCase(timelineName)) {
                    objects = timeline.getEntities();
                }
            }
        }
        return objects;
    }
    
    /**
     * Returns the man made objects associated with the given name.
     * 
     * @param timelineName the name of the TimeLine to return objects from.
     * @return the objects associated with the TimeLine.
     */
    public ManMadeObject[] getAllTimeLineObjects() {
        List<ManMadeObject> objectList = new ArrayList<>();
        for (TimeLine timeline : timeLines) {
            objectList.addAll(Arrays.asList(timeline.getEntities()));
        }
        return objectList.toArray(new ManMadeObject[0]);
    }
    
    /**
     * Return an array of the TimeLines.
     * 
     * @return an array of TimeLines.
     */
    public TimeLine[] getTimeLines() {
        return timeLines;
    }
    
    /**
     * Returns an array of names of the TimeLines.
     * 
     * @return the names of the TimeLines.
     */
    private String[] getTimeLinesNames() {
        String[] timeLineNames;
        timeLineNames = new String[timeLines.length + 1];
        timeLineNames[0] = "None";
        for (int i = 1; i < timeLineNames.length; i++) {
            timeLineNames[i] = timeLines[i-1].getName();
        }
        return timeLineNames;
    }
    
    /**
     * Get a count of the timeLines in this collection.
     * 
     * @return a count of TimeLines.
     */
    public int getCount() {
        return timeLines.length;
    }
    
    /**
     * Returns the comboBox model for the filters.
     * 
     * @return the comboBox model.
     */
    public ComboBoxModel getFilterComboBoxModel() {
        return new DefaultComboBoxModel(filterList.keySet().toArray());
    }
    
    /**
     * Returns the comboBox model for the parameters.
     * 
     * @return the comboBox model.
     */
    public ComboBoxModel getCategoryComboBoxModel() {
        return new DefaultComboBoxModel(getTimeLinesNames());
    }
    
    /**
     * Clears the filter.
     */
    private void createInitialFilter() {
        filters.clear();
        filters.put(none, new TreeMap<>());
        filters.put(query, new TreeMap<>());
        filters.put(source, new TreeMap<>());
        filters.put(depicts, new TreeMap<>());
        filters.put(material, new TreeMap<>());
        filters.put(type, new TreeMap<>());
        filters.put(technique, new TreeMap<>());
        filters.put(creator, new TreeMap<>());
    }
    
}