package main.Variables;

import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * BooleanVariable class - Variable type boolean
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class BooleanVariable extends Variable implements Cloneable{

    private static final String[] possibleTypesForVar = {INT,DOUBLE,BOOLEAN};

    /**
     * Constructor
     * @param name name of the variable
     */
     public BooleanVariable (String name, boolean hasValue, boolean isFinal){
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
    public BooleanVariable (String name, String value, boolean isFinal) throws WrongCastingException{
        this.name = name;
        this.isFinal = isFinal;
        setValue(value);
    }

    @Override
    public void checkValueAd (String value) throws WrongCastingException{
        if ((value.equals("true"))||(value.equals("false"))){ // if true or false
            this.hasValue = true;
            this.value = value;
        }
        try { // if a number
            Double val = Double.parseDouble(value);
            this.hasValue = true;
            this.value = value;
        } //else
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
        return BOOLEAN;
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
