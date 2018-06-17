package main.Variables;

import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * IntVariable class - Variable type Int
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class IntVariable implements Variable{

    private String name;
    private boolean hasValue;

    /**
     * Constructor
     * @param name name of the variable
     */
     IntVariable (String name, boolean hasValue){
        this.name = name;
        this.hasValue = hasValue;
    }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
     IntVariable (String name, String value) throws WrongCastingException{
        this.name = name;
        setValue(value);
    }

    @Override
    public void setValue (String value) throws WrongCastingException{
        try {
            int val = Integer.parseInt(value);
            this.hasValue = true;
        }
        catch (Exception e){
            throw new WrongCastingException();
        }
    }

    @Override
    public String getName (){
        return name;
    }

    @Override
    public String getType(){
        return "int";
    }

    @Override
    public boolean hasValue() {
        return hasValue;
    }

}
