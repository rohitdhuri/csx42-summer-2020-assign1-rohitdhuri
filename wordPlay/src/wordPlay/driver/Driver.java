package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.handler.WordRotator;
import wordPlay.util.Results;
import wordPlay.util.StdoutDisplayInterface;
import wordPlay.util.FileDisplayInterface;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;

/**
 * @author Rohit Mahendra Dhuri
 *
 */
public class Driver {
	public static void main(String[] args) throws InvalidPathException, SecurityException, FileNotFoundException, IOException{

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}

		FileProcessor fp = new FileProcessor(args[0]);
		Results rl = new Results(); 
		WordRotator rt = new WordRotator(fp, rl);
		rt.process();
		
		StdoutDisplayInterface sdi = rl;
		FileDisplayInterface fdi = rl;
		sdi.writeStdout();
		fdi.writeFile();
	}
}
