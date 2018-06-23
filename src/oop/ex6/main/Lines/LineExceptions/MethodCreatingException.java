package oop.ex6.main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when method created inside other method.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */
public class MethodCreatingException extends IllegalLineException{
    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public MethodCreatingException(){
        message="illegal defining of the method";
    }
}
