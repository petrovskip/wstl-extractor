package feature;

import org.jsoup.nodes.Element;

/**
 * Created by Petar on 07.07.2016.
 */
public class CountNonChildTagsFeature extends Feature {


    public CountNonChildTagsFeature(String type) {
        super(type, 3);
    }


    public void compute(Element element) {
        String tagName = element.tagName();
        if(tagName == "table") countNonTableElements(element);
        else if(tagName == "ul" || tagName == "ol") countNonListElements(element);
        else if(tagName == "dl") countNonDescList(element);
    }

    private void countNonTableElements(Element element) {
        int count = 0;
        for(Element child : element.select("*")){
            if(child.tagName() != "td" || child.tagName() != "tr" || child.tagName() != "th") count++;
        }
        this.value = (double) count;
    }

    private void countNonListElements(Element element) {
        int count = 0;
        for(Element child : element.select("*")){
            if(child.tagName() != "li") count++;
        }
        this.value = (double) count;
    }

    private void countNonDescList(Element element) {
        int count = 0;
        for(Element child : element.select("*")){
            if(child.tagName() != "dt"|| child.tagName() != "td") count++;
        }
        this.value = (double) count;
    }

}
