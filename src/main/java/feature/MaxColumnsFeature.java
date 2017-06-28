package feature;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Petar on 07.07.2016.
 */

public class MaxColumnsFeature extends Feature {


    public MaxColumnsFeature(String type) {
        super(type, 6);
    }

    public void compute(Element element) {
        List<Integer> counts = new ArrayList<Integer>();
        for (Element row : element.getElementsByTag("tr")) {
            counts.add(row.getElementsByTag("td").size());
        }
        this.value = Collections.max(counts);
    }
}
