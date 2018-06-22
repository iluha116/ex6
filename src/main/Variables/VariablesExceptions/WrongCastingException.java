package main.Variables.VariablesExceptions;

import main.Variables.VariablesExceptions.VariableException;

/**
 * Exception class
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class WrongCastingException extends VariableException {
    public WrongCastingException(){
        message="type of value is not appropriate";
    }
}
