package oop.ex6.main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when variable that was called have no value.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class ParameterHasNoValueException extends IllegalLineException{
    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public ParameterHasNoValueException(){
        message="was used parameter that have no value";
    }
}
