package wordPlay.util;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    public String op;
    public float a_number_words, a_length_words;

    public Results() {
        op = "";
    }

    public void writeStdout() {
        System.out.println(op);
        System.out.println("Average number of words: " + a_number_words + "\nAverage length of words: " + a_length_words);
    }

    public void writeFile() {
        try {
            FileWriter outputFile = new FileWriter("output.txt");
            outputFile.write(op);
            outputFile.close();

            FileWriter metricsFile = new FileWriter("metrics.txt");
            metricsFile.write("Average number of words: " + a_number_words + "\nAverage length of words: " + a_length_words);
            metricsFile.close();

            System.out.println("Successfully wrote to files.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}