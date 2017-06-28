package feature;

import org.jsoup.nodes.Element;

/**
 * Created by Petar on 28.06.2016.
 */
public class LinkCountFeature extends Feature {


    public LinkCountFeature(String type) {
        super(type, 5);
    }

    public void compute(Element element) {
        this.value = element.getElementsByTag("a").size();
    }



}
