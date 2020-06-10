package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.helperP.Helper;
import wordPlay.util.Results;
import wordPlay.util.StdoutDisplayInterface;
import wordPlay.util.FileDisplayInterface;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import wordPlay.util.exception.MissingLineException;
import wordPlay.util.exception.SpecialCharacterException;
import wordPlay.util.exception.EmptyFileException;

/**
 * @author Rohit Mahendra Dhuri
 *
 */
public class Driver {
	public static void main(String[] args){

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		try{
			FileProcessor fp = new FileProcessor(args[0]);
			Results rlOutput = new Results(args[1]); 
			Results rlMetrics = new Results(args[2]);
			Helper hl = new Helper(fp, rlOutput, rlMetrics);
			hl.process();
			
			StdoutDisplayInterface sdiOutput = rlOutput;
			FileDisplayInterface fdiOutput = rlOutput;
			StdoutDisplayInterface sdiMetrics = rlMetrics;
			FileDisplayInterface fdiMetrics = rlMetrics;
			sdiOutput.writeToStdout();
			sdiMetrics.writeToStdout();
			fdiOutput.writeToFile();
			fdiMetrics.writeToFile();
		}
		catch(InvalidPathException e){
		System.err.println(e.getMessage());
		}
		catch(FileNotFoundException e){
		System.err.println(e.getMessage());
		}
		catch(IOException e){
		System.err.println(e.getMessage());
		}
		catch(MissingLineException e){
		System.err.println(e.getMessage());
		}
		catch(SpecialCharacterException e){
		System.err.println(e.getMessage());
		}
		catch(EmptyFileException e){
		System.err.println(e.getMessage());
		}
	}
}
