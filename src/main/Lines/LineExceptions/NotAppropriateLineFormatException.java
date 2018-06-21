package main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when string is not appropriate to existed patterns.
 */
public class NotAppropriateLineFormatException extends IllegalLineException{
    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public NotAppropriateLineFormatException(){
        message="format of the line is not appropriate.";
    }
}
