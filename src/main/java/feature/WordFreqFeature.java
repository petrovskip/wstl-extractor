package feature;

import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import org.jsoup.nodes.Element;

/**
 * Created by Petar on 28.06.2016.
 */
public class WordFreqFeature extends Feature {

    private String word;

    public WordFreqFeature(String type, String word) {
        super(type, 11);
        this.word = word;
    }

    public void compute(Element element) {
        //initialize tokenizer
        Tokenizer tokenizer = SimpleTokenizer.INSTANCE;

        //get tokens
        String[] tokens = tokenizer.tokenize(element.text());

        int wordCounter = 0;
        for(String token: tokens) if(token.equals(word)) wordCounter++;

        this.value = wordCounter/(double)tokens.length;
    }

    public double getValue() {
        return value;
    }

}
