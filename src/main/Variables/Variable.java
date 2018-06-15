package main.Variables;

import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * interface Variable
 * @author Ilia Bogov
 * @author Shani Cheskis
 */


public interface Variable {

    /**
     * Sets the given value to the variable, if can't throws WrongCastingException
     * @param value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
    public void setValue (String value) throws VariableException;

    public String getName();

    public String getType();

    public String getValue();



}
