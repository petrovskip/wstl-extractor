package feature;

import org.jsoup.nodes.Element;

/**
 * Created by Petar on 07.07.2016.
 */
public class MaxRowsFeature extends Feature {


    public MaxRowsFeature(String type) {
        super(type, 7);
    }

    public void compute(Element element) {
        this.value = (double) element.getElementsByTag("tr").size();
    }


}
