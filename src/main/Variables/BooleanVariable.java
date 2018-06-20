package main.Variables;

import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * BooleanVariable class - Variable type boolean
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class BooleanVariable extends Variable implements Cloneable{

    /**
     * Constructor
     * @param name name of the variable
     */
     BooleanVariable (String name, boolean hasValue){
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
     BooleanVariable (String name, String value) throws WrongCastingException{
        this.name = name;
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
        return "boolean";
    }

    @Override
    public boolean hasValue() {
        return hasValue;
    }
}
