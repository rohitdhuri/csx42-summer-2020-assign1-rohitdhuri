package wordPlay.handler;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;


public class WordRotator {

    private int j;

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