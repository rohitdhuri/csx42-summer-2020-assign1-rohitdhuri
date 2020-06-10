package wordPlay.handler;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;

/**
 * Defines a function which rotates the word
 *
 * @author Rohit Mahendra Dhuri
 * 
 */

public class WordRotator {

    private int j;

    /**
     * rotates the string which is passed as its parameter by the amount of shift
     * and returns the rotated strings
     */

    public String rotate(String str, int shift) {
        
        for (j = 0; j < shift; j++) {
            str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override
    public String toString(){
        return "j= " + j;
    }

}