package main.Variables;

import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * DoubleVariable class - Variable type Double
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class DoubleVariable implements Variable {

    private String name;
    private double value;
    private static final int DEFAULT = 0;

    /**
     * Constructor
     * @param name name of the variable
     */
    public DoubleVariable (String name){
        this.name = name;
        this.value = DEFAULT;
    }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
    public DoubleVariable (String name, String value) throws WrongCastingException{
        this.name = name;
        setValue(value);
    }

    @Override
    public void setValue (String value) throws WrongCastingException{
        try {
            this.value = Double.parseDouble(value);
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
        return "double";
    }

    @Override
    public String getValue() {
        return Double.toString(value);
    }

}
