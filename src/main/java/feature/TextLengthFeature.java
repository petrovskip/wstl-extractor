package feature;

import org.jsoup.nodes.Element;

/**
 * Created by Petar on 28.06.2016.
 */
public class TextLengthFeature extends Feature {


    public TextLengthFeature(String type) {
        super(type, 10);
    }

    public void compute(Element element) {
        this.value = (double) element.text().length();
    }


}
