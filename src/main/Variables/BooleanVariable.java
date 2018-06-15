package main.Variables;

import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * BooleanVariable class - Variable type boolean
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class BooleanVariable implements Variable{

    private String name;
    private String value;
    private static final String DEFAULT = "true";


    /**
     * Constructor
     * @param name name of the variable
     */
     BooleanVariable (String name){
        this.name = name;
        this.value = DEFAULT;
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
    public void setValue (String value) throws WrongCastingException{
        if ((value.equals("true"))||(value.equals("false"))){ // if true or false
            this.value = value;
        }
        try { // if a number
            Double val = Double.parseDouble(value);
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
    public String getValue() {
        return value;
    }
}
