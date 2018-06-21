package main.Variables;

import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * CharVariable class - Variable type Char
 * @author Shani Cheskis
 * @author Ilia Bogov
 */


public class CharVariable extends Variable implements Cloneable{
    /*appropriate types of variables. */
    private static final String[] possibleTypesForVar = {CHAR};

    /**
     * Constructor
     * @param name name of the variable
     */
     public CharVariable (String name, boolean hasValue, boolean isFinal){
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
     public CharVariable (String name, String value, boolean isFinal) throws VariableException {
         this.name = name;
         this.isFinal = isFinal;
         checkValue(value);
     }

    @Override
    public void checkValueAd (String value) throws WrongCastingException{
        try {
            if ((value.charAt(0)=='\'')&&(value.charAt(value.length()-1)=='\'')&&(value.length()==3)){
                // if starts and ends with " so it is a string value,
                // and the length with " is 3  so it is a char
                setValue(value);
            }
            else {
                throw new WrongCastingException();
            }
        }
        catch (Exception e){ // if was empty and had no 0 and length-1 indexes
            throw new WrongCastingException();
        }
    }

    @Override
    public String getName (){
        return name;
    }

    @Override
    public String getType(){
        return CHAR;
    }

    @Override
    public boolean hasValue() {
        return hasValue;
    }

    @Override
    public String[] possibleTypesForVariable (){
        return possibleTypesForVar;
    }

}
