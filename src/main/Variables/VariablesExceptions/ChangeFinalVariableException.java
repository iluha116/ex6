package main.Variables.VariablesExceptions;

import main.CodeException;

public class ChangeFinalVariableException extends VariableException {
    public ChangeFinalVariableException(){
        message="attempt to change value of final variable.";
    }
}
