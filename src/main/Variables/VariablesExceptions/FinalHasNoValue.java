package main.Variables.VariablesExceptions;

/**
 * This class represents exception thrown in cases when
 * final variable was defined without value.
 */
public class FinalHasNoValue extends VariableException{
    /**
     * Constructor
     */
    public FinalHasNoValue(){
        message="attempt to define final variable without value.";
    }
}
