package main.Lines.LineExceptions;
/**
 * This class represents exception that thrown in case when char '}' was used in illegal way.
 */
public class EndScopeException extends IllegalLineException{
    public EndScopeException(){
        message="it is not appropriate place for char '}'";
    }
}
