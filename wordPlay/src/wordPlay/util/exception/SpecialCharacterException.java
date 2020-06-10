package wordPlay.util.exception;

public class SpecialCharacterException extends Exception{

/**
 * SpecialCharacterException class
 * 
 * @author Rohit Mahendra Dhuri
 * 
 */

    /**
     * SpecialCharacterException constructor calling the parent class
     * object
     * 
     * @param s - The error message
     */

    public SpecialCharacterException(String s){
        super(s);
    }


    @Override
    public String toString() {
        return "Class: SpecialCharacterException, Data Members: [ ]";
    }


}