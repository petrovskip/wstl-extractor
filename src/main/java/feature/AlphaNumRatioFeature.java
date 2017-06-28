package feature;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Petar on 07.07.2016.
 */
public class AlphaNumRatioFeature extends Feature {


    public AlphaNumRatioFeature(String type) {
        super(type, 1);
    }

    public void compute(Element element) {
        Elements cells = element.getElementsByTag("td");
        double[] ratios = new double[cells.size()];
        int count = 0;
        for(Element cell : cells){
            ratios[count] = computeRatio(cell);
            count++;
        }

        this.value = avg(ratios);
    }

    private double avg(double[] ratios) {
        double sum = 0.0;
        for(int i=0; i < ratios.length; i++){
            sum += ratios[i];
        }
        return sum/ratios.length;
    }

    private double computeRatio(Element cell) {
        String text = cell.text();
        int digits = 0, letters = 0;
        for (int i = 0; i < text.length(); i++){
            if(Character.isDigit(text.charAt(i))) digits++;
            if(Character.isLetter(text.charAt(i))) letters++;
        }
        return digits/letters;
    }
}
