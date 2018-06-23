package oop.ex6.main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when a variable
 * was assign with variable with another type.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */


public class VariableTypesAreNotCompatibleException extends IllegalLineException{
    /**
     * Constructor
     */
    public VariableTypesAreNotCompatibleException(){
        message="Variable types are not compatible";
    }
}
