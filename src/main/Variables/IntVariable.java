package main.Variables;

import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * IntVariable class - Variable type Int
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class IntVariable extends Variable implements Cloneable{

    /**
     * Constructor
     * @param name name of the variable
     */
     IntVariable (String name, boolean hasValue){
        this.name = name;
        this.hasValue = hasValue;
        this.value = DEFAULT_VALUE;
    }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
     IntVariable (String name, String value) throws VariableException {
         this.name = name;
         checkValue(value);
    }

    @Override
    public void checkValueAd (String value) throws VariableException{
        try {
            int val = Integer.parseInt(value);
            this.hasValue = true;
            this.value = value;
        }
        catch (Exception e){
            throw new WrongCastingException();
        }
    }

    @Override
    public String getType(){
        return "int";
    }



}
