package feature;

import org.jsoup.nodes.Element;

/**
 * Created by Petar on 28.06.2016.
 */
public class ImgCountFeature extends Feature {



    public ImgCountFeature(String type) {
        super(type, 4);
    }

    public void compute(Element element) {
        this.value = element.getElementsByTag("img").size();
    }


}
