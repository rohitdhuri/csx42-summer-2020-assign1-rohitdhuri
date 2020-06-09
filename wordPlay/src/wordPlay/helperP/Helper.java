package wordPlay.helperP;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;

public class Helper{

    private FileProcessor fp;
    private Results rl_output;
    private Results rl_metrics;
    private WordRotator wr = new WordRotator();
    private MetricsCalculator mc = new MetricsCalculator();
    private double wordCount, wordLength;
    private int lineNumber;
    private String opBuffer;

    public Helper(FileProcessor inFp, Results inRl_output, Results inRl_metrics)
    {
        fp = inFp;
        rl_output = inRl_output;
        rl_metrics = inRl_metrics;
    }

    public void process() throws IOException
    {

        String str = fp.poll();
        int j, shift = 0;
        wordCount = wordLength = lineNumber = 0;
        opBuffer = "";

        while (str != null) {
            shift++;
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
                str = wr.rotate(str, shift);
                wordLength = wordLength + str.length();
                
                opBuffer = opBuffer.concat(str);
                ++wordCount;
                str = fp.poll();
                shift = 0;
                opBuffer=(opBuffer).concat(".\n");
                if (str == null)
                    break;
                lineNumber++;
                
            } else {
                str = wr.rotate(str, shift);
                wordLength = wordLength + str.length();
                opBuffer = (opBuffer).concat(str).concat(" ");
                ++wordCount;
                str = fp.poll();
            }
        }
        rl_output.storeOutput(opBuffer);
        opBuffer = mc.cal(wordCount, wordLength, lineNumber);
        rl_metrics.storeMetrics(opBuffer);

    }
}