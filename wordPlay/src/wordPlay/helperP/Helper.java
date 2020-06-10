package wordPlay.helperP;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper{

    private FileProcessor fp;
    private Results rl_output;
    private Results rl_metrics;
    private WordRotator wr = new WordRotator();
    private MetricsCalculator mc = new MetricsCalculator();
    private double wordCount, wordLength;
    private int lineNumber;
    private String opBuffer;
    private String regExp = "[A-Za-z0-9\\s\\.]+";

    public Helper(FileProcessor inFp, Results inRl_output, Results inRl_metrics)
    {
        fp = inFp;
        rl_output = inRl_output;
        rl_metrics = inRl_metrics;
    }

    public void checkSpecialC(String str)
    {
        if(!str.matches(regExp)){
            System.out.println("ERROR: Word '"+str + "' contains special character\nExiting...");
            System.exit(0);
        }
    }

    public void process() throws IOException
    {
        int j, shift = 0;
        wordCount = wordLength = lineNumber = 0;
        opBuffer = "";
        String str = fp.poll();
        
        if(str==null){
            System.err.println("ERROR: Empty File.");
            System.exit(0); 
        }

        while (str != null) {
            
            if(str.isEmpty()){
                System.err.println("ERROR: Missing line.");
                System.exit(0);
            }

            checkSpecialC(str);
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

    @Override
    public String toString(){
        return "opBuffer= " + opBuffer + " wordCount= " + wordCount + " wordLength= " + wordLength + " lineNumber= " + lineNumber;
    }
}