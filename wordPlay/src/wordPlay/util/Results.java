package wordPlay.util;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String output;
    private String filePath;

    public Results( String path) {
        filePath = path;
    }

    public void storeOutput(String buffer)
    {
        output = buffer;
    }

    public void storeMetrics(String metrics)
    {
        output = metrics;
    }

    public void writeToStdout() {
        System.out.println(output);
    }

    public void writeToFile() {
        try {
            FileWriter outputFile = new FileWriter(filePath);
            outputFile.write(output);
            outputFile.close();
            System.out.println("Successfully wrote to file.");
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    @Override
    public String toString(){
        return "output= " + output + " filePath= " + filePath;
    }

}