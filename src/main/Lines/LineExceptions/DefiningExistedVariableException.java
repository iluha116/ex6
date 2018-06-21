package main.Lines.LineExceptions;


/**
 * This class represents exception that thrown in case when is
 * defined new variable with name that already exists in the scope.
 */
public class DefiningExistedVariableException extends IllegalLineException{
    public DefiningExistedVariableException(){
        message="attempt to define a variable that already exist in the scope";
    }
}
