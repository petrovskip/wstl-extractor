package feature;

import org.jsoup.nodes.Element;

/**
 * Created by Petar on 28.06.2016.
 */
public class RowAvgTextLengthFeature extends Feature {


    public RowAvgTextLengthFeature(String type) {
        super(type, 8);
    }

    public void compute(Element element) {

        //get row count
        int rowCount = element.getElementsByTag("tr").size();

        double result = 0.0;

        //get lengths per row
        for(int i=0; i<element.getElementsByTag("tr").size();i++){
            Element el = element.getElementsByTag("tr").get(i);
            result += (double) el.text().length();
        }

        this.value = result/rowCount;
    }

}
