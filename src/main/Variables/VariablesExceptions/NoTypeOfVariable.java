package main.Variables.VariablesExceptions;


/**
 * This class represents exception thrown in cases when variable was defined without a type.
 */
public class NoTypeOfVariable extends VariableException {
    /**
     * Constructor
     */
    public NoTypeOfVariable(){
        message="Variable cannot be defined without type.";
    }
}
