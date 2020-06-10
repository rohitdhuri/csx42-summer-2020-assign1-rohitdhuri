package wordPlay.helperP;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import wordPlay.util.exception.MissingLineException;
import wordPlay.util.exception.SpecialCharacterException;
import wordPlay.util.exception.EmptyFileException;

/**
 * Helper class acts as an intermediate class which co-ordinates all 
 * functions
 * 
 * @author Rohit Mahendra Dhuri
 * 
 */

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

    /**
     * Constructor copies all the instances into local variables
     */

    public Helper(FileProcessor inFp, Results inRl_output, Results inRl_metrics) {
        fp = inFp;
        rl_output = inRl_output;
        rl_metrics = inRl_metrics;
    }

    /**
     * throws an exception if any special character is found
     */

    public void checkSpecialC(String str) throws SpecialCharacterException{
        if(!str.matches(regExp)){
            throw new SpecialCharacterException("Special character found.");
        }
    }

    /**
    * iterates throught the input file by polling in each iteration until the end of file 
    * also maintains three varaibles wordCount, wordLength, lineNumber which are passed to the metricsCaluclator
    */

    public void process() throws IOException, EmptyFileException, MissingLineException, SpecialCharacterException {
        
    /**
     * shift - is times that the word must be rotated
     *
     */
        
        int j, shift = 0;
        wordCount = wordLength = lineNumber = 0;
        opBuffer = "";
        String str = fp.poll();
        
        /**
         * throws an exception if the file is empty
         *
         */

        if(str==null){
            throw new EmptyFileException("File is empty.");
        }
        
        /**
        * while loop runs until a null value is returned by a poll 
        *
        */

        while (str != null) {
         
            /**
            * throws an exception if a line is missing
            *
            */

            if(str.isEmpty()){
                throw new MissingLineException("Missing Line.");
            }

            checkSpecialC(str);
            shift++;

            /**
             * enters this if block for the last word on the line
             *
             */
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
                str = wr.rotate(str, shift);
                wordLength = wordLength + str.length();
                opBuffer = opBuffer.concat(str);
                ++wordCount;
                str = fp.poll();
                shift = 0;
                opBuffer=(opBuffer).concat(".\n");

                /**
                 * breaks if this was the last word in
                 * the file
                 */

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

        /**
         * Overwriting the opBuffer with the metrics which is then stored
         *
         */

        rl_output.storeOutput(opBuffer);
        opBuffer = mc.cal(wordCount, wordLength, lineNumber);
        rl_metrics.storeMetrics(opBuffer);

    }

    @Override
    public String toString(){
        return "opBuffer= " + opBuffer + " wordCount= " + wordCount + " wordLength= " + wordLength + " lineNumber= " + lineNumber;
    }
}