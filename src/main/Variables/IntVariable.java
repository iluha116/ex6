package main.Variables;

import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * IntVariable class - Variable type Int
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class IntVariable extends Variable implements Cloneable{
    /*appropriate types of variables. */
    private static final String[] possibleTypesForVar = {INT};

    /**
     * Constructor
     * @param name name of the variable
     */
     public IntVariable (String name, boolean hasValue, boolean isFinal){
         this.name = name;
         this.hasValue = hasValue;
         this.value = DEFAULT_VALUE;
         this.isFinal = isFinal;
     }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
     public IntVariable (String name, String value, boolean isFinal) throws VariableException {
         this.name = name;
         this.isFinal = isFinal;
         checkValue(value);
    }

    @Override
    public void checkValueAd (String value) throws VariableException{
        try {
            int val = Integer.parseInt(value);
            setValue(value);
        }
        catch (Exception e){
            throw new WrongCastingException();
        }
    }

    @Override
    public String getType(){
        return INT;
    }

    @Override
    public String[] possibleTypesForVariable (){
        return possibleTypesForVar;
    }


}
