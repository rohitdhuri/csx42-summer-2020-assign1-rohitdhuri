package wordPlay.handler;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;


public class WordRotator {
    float wordCount, wordLength;
    int lineNumber;



    public String rotate(String str, int shift) {
        
        for (int j = 0; j < shift; j++) {
            str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        }
        return str;
    }



}