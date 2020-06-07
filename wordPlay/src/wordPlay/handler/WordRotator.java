package wordPlay.handler;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;

public class WordRotator {
    private FileProcessor fp;
    private Results rl;
    public WordRotator(FileProcessor inFp, Results inRl) {
        fp = inFp;
        rl = inRl;
    }

    public static String rotateString(String str, int shift) {
        for (int j = 0; j < shift; j++) {
            str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        }
        return str;
    }

    public void process() throws IOException {

        String str = fp.poll();
        int j, shift = 0;
        float wordCount = 0, wordLength = 0;
        int lineNumber = 0;

        while (str != null) {
            shift++;
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
                str = rotateString(str, shift);
                wordLength = wordLength + str.length();
                
                rl.op = rl.op.concat(str);
                ++wordCount;
                str = fp.poll();
                shift = 0;
                rl.op=(rl.op).concat(".\n");
                if (str == null)
                    break;
                lineNumber++;
                
            } else {
                str = rotateString(str, shift);
                wordLength = wordLength + str.length();
                rl.op = (rl.op).concat(str).concat(" ");
                ++wordCount;
                str = fp.poll();
            }
        }

        rl.a_number_words = wordCount / (lineNumber + 1);
        rl.a_length_words = wordLength / wordCount;
    }
}