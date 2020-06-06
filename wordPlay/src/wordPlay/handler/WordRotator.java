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
        int n= str.length();
        String nstr="";
        int j,shift=0;

        while(str != null)
        {   
            System.out.println(str);
            shift++;          
            for(j=0;j<shift;j++)
                str= str.charAt(str.length()-1) + str.substring(0,str.length()-1);
            System.out.println("new: " + str);    
            str = fp.poll();
        }
    }
}