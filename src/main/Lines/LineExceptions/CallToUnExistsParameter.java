package main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when variable that is not exist called.
 */

public class CallToUnExistsParameter extends IllegalLineException{
    /**
     * this method represents constructor where exception receive the message.
     */
    public CallToUnExistsParameter(){
        message="ERROR: the called variable is not exist ";
    }
}
