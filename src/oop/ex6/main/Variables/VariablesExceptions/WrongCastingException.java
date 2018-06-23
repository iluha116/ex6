package oop.ex6.main.Variables.VariablesExceptions;

import oop.ex6.main.Variables.VariablesExceptions.VariableException;

/**
 * This class represents exception thrown in cases of illegal casting.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class WrongCastingException extends VariableException {
    /**
     * Constructor
     */
    public WrongCastingException(){
        message="type of value is not appropriate";
    }
}
