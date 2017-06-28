package feature;

import org.jsoup.nodes.Element;


/**
 * Created by Petar on 07.07.2016.
 */
public class StdDevColumnsFeature extends Feature {


    public StdDevColumnsFeature(String type) {
        super(type, 9);
    }

    public void compute(Element element) {
        double[] counts = new double[element.getElementsByTag("tr").size()];
        int count = 0;
        for(Element row : element.getElementsByTag("tr")){
            counts[count] = (row.getElementsByTag("td").size());
            count++;
        }
        this.value = getStdDev(counts);
    }

    private double getMean(double[] counts)
    {
        double sum = 0.0;
        for(double a : counts)
            sum += a;
        return sum/counts.length;
    }

    private double getVariance(double[] counts)
    {
        double mean = getMean(counts);
        double temp = 0;
        for(double a :counts)
            temp += (mean-a)*(mean-a);
        return temp/counts.length;
    }

    private double getStdDev(double[] counts)
    {
        return Math.sqrt(getVariance(counts));
    }

}
