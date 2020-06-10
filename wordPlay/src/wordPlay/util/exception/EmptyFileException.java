package wordPlay.util.exception;

public class EmptyFileException extends Exception{


    public EmptyFileException(String s){
        super(s);
    }


    @Override
    public String toString() {
        return "Class: EmptyFileException, Data Members: [ ]";
    }


}