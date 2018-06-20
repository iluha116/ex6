package main.Variables;
import main.Variables.VariablesExceptions.*;

/**
 * StringVariable class - Variable type String
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class StringVariable extends Variable implements Cloneable{

    /**
     * Constructor
     * @param name name of the variable
     */
     StringVariable (String name, boolean hasValue){
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
     StringVariable (String name, String value) throws VariableException {
        this.name = name;
        checkValue(value);
    }

    @Override
    public void checkValueAd (String value) throws WrongCastingException{
        try {
            if ((value.charAt(0)=='"')&&(value.charAt(value.length()-1)=='"')){
                // if starts and ends with " so it is a string value
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
    public String getType(){
        return "String";
    }


}
