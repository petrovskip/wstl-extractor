package detection.model;

import data.Example;
import feature.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Petar on 07.07.2016.
 */
public class TableDetectionModel extends DetectionModel {

    public void setExamples(Elements elements){
        List<Feature> features;
        int count = 0;

        for(Element element:elements){
            features = new ArrayList<Feature>();
            features.add(new AlphaNumRatioFeature("continuous"));
            features.add(new AvgColumnsFeature("continuous"));
            features.add(new CountNonChildTagsFeature("continuous"));
            features.add(new ImgCountFeature("continuous"));
            features.add(new LinkCountFeature("continuous"));
            features.add(new MaxColumnsFeature("continuous"));
            features.add(new MaxRowsFeature("continuous"));
            features.add(new RowAvgTextLengthFeature("continuous"));
            features.add(new StdDevColumnsFeature("continuous"));
            features.add(new TextLengthFeature("continuous"));
            features.add(new WordFreqFeature("continuous", "specification"));
            for(Feature feature : features){
                feature.compute(element);
            }
            Example example = new Example(count, element, 1, features);
            examples.add(example);
        }
    }
}
