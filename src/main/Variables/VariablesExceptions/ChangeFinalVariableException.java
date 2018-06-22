package main.Variables.VariablesExceptions;

import main.CodeException;

/**
 * This class represents exception thrown in cases when there was an attempt to value of final variable
 */
public class ChangeFinalVariableException extends VariableException {
    /*Constructor. */
    public ChangeFinalVariableException(){
        message="attempt to change value of final variable.";
    }
}
