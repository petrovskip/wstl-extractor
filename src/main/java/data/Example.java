package data;

import feature.Feature;
import org.jsoup.nodes.Element;

import java.util.List;

/**
 * Created by Petar on 07.07.2016.
 */
public class Example {

    private int id;
    private Element element;
    private int label;
    private List<Feature> features;

    public Example(int id, Element element, int label, List<Feature> features) {
        this.id = id;
        this.element = element;
        this.label = label;
        this.features = features;
    }

    public int getId() {
        return id;
    }

    public Element getElement() {
        return element;
    }

    public int getLabel() {
        return label;
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
