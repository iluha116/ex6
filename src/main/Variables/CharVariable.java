package main.Variables;

import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * CharVariable class - Variable type Char
 * @author Shani Cheskis
 * @author Ilia Bogov
 */


public class CharVariable implements Variable {

    private String name;
    private String value;
    private static final String DEFAULT = "";

    /**
     * Constructor
     * @param name name of the variable
     */
     CharVariable (String name){
        this.name = name;
        this.value = DEFAULT;
    }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
     CharVariable (String name, String value) throws WrongCastingException{
        this.name = name;
        setValue(value);
    }

    @Override
    public void setValue (String value) throws WrongCastingException{
        try {
            if ((value.charAt(0)=='"')&&(value.charAt(value.length()-1)=='"')&&(value.length()==3)){
                // if starts and ends with " so it is a string value,
                // and the length with " is 3  so it is a char
                this.value = value;
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
        return "char";
    }

    @Override
    public String getValue() {
        return value;
    }

}
