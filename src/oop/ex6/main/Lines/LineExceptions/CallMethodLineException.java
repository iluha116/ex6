package oop.ex6.main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when call of method was made in illegal way.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class CallMethodLineException extends IllegalLineException{
    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public CallMethodLineException(){
        message="was made illegal calling of the method";
    }
}
