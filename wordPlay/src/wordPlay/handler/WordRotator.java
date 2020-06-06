package wordPlay.handler;
import wordPlay.util.FileProcessor;
import java.io.IOException;

public class WordRotator
{
    private FileProcessor fp;

    public WordRotator(FileProcessor inFp){
        fp=inFp;
    }

    public void process() throws IOException
    {
        String str = fp.poll();
        while(str != null)
        {
            System.out.println(str);
            str = fp.poll();
        }
    }
}