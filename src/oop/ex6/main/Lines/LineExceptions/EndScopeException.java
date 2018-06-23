package oop.ex6.main.Lines.LineExceptions;
/**
 * This class represents exception that thrown in case when char '}' was used in illegal way.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */
public class EndScopeException extends IllegalLineException{

    /**
     * Constructor
     */
    public EndScopeException(){
        message= "it is not appropriate place for char '}'";
    }
}
