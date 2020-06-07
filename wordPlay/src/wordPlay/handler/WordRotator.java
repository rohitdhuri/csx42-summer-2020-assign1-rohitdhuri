package wordPlay.handler;
import wordPlay.util.FileProcessor;
import java.io.IOException;

public class WordRotator
{
    private FileProcessor fp;

    public WordRotator(FileProcessor inFp)
    {
        fp=inFp;
    }

    public static String rotateString(String str, int shift)
    {
        for(int j=0;j<shift;j++)
        {    
            str= str.charAt(str.length()-1) + str.substring(0,str.length()-1);
        }
        return str;
    }

    public void process() throws IOException
    {   
        
        String str = fp.poll();
        int j,shift=0;
        float wordCount=0, wordLength=0;
        int lineNumber=0;

        while(str != null)
        {   
            System.out.println(str);
            shift++;
            if(str.endsWith("."))
            {   
                str=str.substring(0,str.length()-1);
                str = rotateString(str,shift);
                wordLength = wordLength + str.length();             
                str= str + ".";
                System.out.println("new: " + str);
                ++wordCount;
                str = fp.poll();
                shift=0;
                if(str == null)
                break;
                lineNumber++;
                System.out.println("\nNew line");          
            }
            else
            {
                str = rotateString(str,shift);
                wordLength = wordLength + str.length();
                System.out.println("new: " + str);
                ++wordCount;
                str = fp.poll();
            }
        }

        System.out.println("\n Average number of words = " + wordCount/(lineNumber+1));
        System.out.println("\n Average length of words = " + wordLength/wordCount);
    }
}