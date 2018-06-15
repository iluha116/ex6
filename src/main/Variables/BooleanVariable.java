package main.Variables;

/**
 * BooleanVariable class - Variable type boolean
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class BooleanVariable implements Variable{

    private String name;
    private String value;

    /**
     * Constructor
     * @param name name of the variable
     */
    public BooleanVariable (String name){
        this.name = name;
    }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
    public BooleanVariable (String name, String value) throws WrongCastingException{
        this.name = name;
        setValue(value);
    }

    @Override
    public void setValue (String value) throws WrongCastingException{
        if ((value=="true")||(value=="false")){ // if true or false
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
}
