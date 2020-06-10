package wordPlay.util.exception;

public class MissingLineException extends Exception{

    private static final long serialVersionUID = 1L;

    public MissingLineException(String s){
        super(s);
    }


    @Override
    public String toString() {
        return "Class: MissingLineException, Data Members: [ ]";
    }


}