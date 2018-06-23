package main.Variables;

import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * BooleanVariable class - Variable type boolean
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class BooleanVariable extends Variable implements Cloneable{
    /*appropriate types of variables. e.g. boolean variable may also be defined with double and int. */
    private static final String[] possibleTypesForIfWhile = {INT,DOUBLE,BOOLEAN};

    /**
     * Constructor
     * @param name name of the variable
     */
     public BooleanVariable (String name, boolean hasValue){
         this.name = name;
         this.hasValue = hasValue;
         this.value = DEFAULT_VALUE;
         this.possibleTypesForVar = new String[]{INT,DOUBLE,BOOLEAN};
    }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
    public BooleanVariable (String name, String value) throws VariableException {
        this.name = name;
        this.possibleTypesForVar = new String[]{INT,DOUBLE,BOOLEAN};
        checkValue(value);
    }

    @Override
    public void checkValueAd (String value) throws WrongCastingException{
        if ((value.equals("true"))||(value.equals("false"))){ // if true or false
            this.hasValue = true;
            this.value = value;
        }
        else {
            try { // if a number
                Double val = Double.parseDouble(value);
                this.hasValue = true;
                this.value = value;
            } //else
            catch (Exception e){ // if was empty and had no 0 and length-1 indexes
                throw new WrongCastingException();
            }
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

    /**
     * @return valid types of variables, legal for If/While.
     */
    public static String[] possibleTypesForBoolean (){
        return possibleTypesForIfWhile;
    }


}
