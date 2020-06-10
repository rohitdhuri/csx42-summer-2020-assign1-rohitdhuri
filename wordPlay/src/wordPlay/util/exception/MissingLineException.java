package wordPlay.util.exception;

public class MissingLineException extends Exception{

/**
 * MissingLineException class
 * 
 * @author Rohit Mahendra Dhuri
 * 
 */

    /**
     * MissingLineException constructor calling the parent class
     * object
     * 
     * @param s - The error message
     */

    public MissingLineException(String s){
        super(s);
    }


    @Override
    public String toString() {
        return "Class: MissingLineException, Data Members: [ ]";
    }


}