package main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when there
 * was attempt to use return in illegal place.
 */

public class ReturnException extends IllegalLineException{
    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public ReturnException(){
        message="illegal using of return line";
    }
}
