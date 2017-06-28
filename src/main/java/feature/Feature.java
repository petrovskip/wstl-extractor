package feature;

/**
 * Created by Petar on 28.06.2016.
 */
public abstract class Feature implements FeatureInterface {
    private String type;
    double value;
    private int id;

    public Feature(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }
}
