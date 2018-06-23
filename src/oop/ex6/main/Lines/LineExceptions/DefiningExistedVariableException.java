package oop.ex6.main.Lines.LineExceptions;


/**
 * This class represents exception that thrown in case when is
 * defined new variable with name that already exists in the scope.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */
public class DefiningExistedVariableException extends IllegalLineException{
    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public DefiningExistedVariableException(){
        message="attempt to define a variable that already exist in the scope";
    }
}
