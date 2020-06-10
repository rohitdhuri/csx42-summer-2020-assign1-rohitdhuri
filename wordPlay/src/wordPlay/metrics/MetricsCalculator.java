package wordPlay.metrics;
import wordPlay.util.Results;
import java.text.DecimalFormat;

public class MetricsCalculator{

    private String op;
    private String a_number_words;
    private String a_length_words;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public String cal(double wordCount, double wordLength, int lineNumber)
    {
        
        op = "";
        a_number_words = df.format(wordCount / (lineNumber + 1));
        a_length_words = df.format(wordLength / wordCount);
        op = "AVG_NUM_WORDS_PER_SENTENCE = " + (a_number_words) + "\nAVG_WORD_LENGTH = " + (a_length_words) + "\n";
        return op;
    }

    @Override
    public String toString(){
        return "op= " + op + " a_number_words" + a_number_words + " a_length_words= " + a_length_words;
    }
}