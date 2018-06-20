package main.Variables;

import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * DoubleVariable class - Variable type Double
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class DoubleVariable extends Variable implements Cloneable {

    private static final String[] possibleTypesForVar = {INT,DOUBLE};

    /**
     * Constructor
     * @param name name of the variable
     */
     DoubleVariable (String name, boolean hasValue, boolean isFinal){
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
     DoubleVariable (String name, String value, boolean isFinal) throws WrongCastingException{
        this.name = name;
        setValue(value);
    }

    @Override
    public void checkValueAd (String value) throws WrongCastingException{
        try {
            double val = Double.parseDouble(value);
            this.hasValue = true;
            this.value = value;
        }
        catch (Exception e){
            throw new WrongCastingException();
        }
    }

    @Override
    public String getType(){
        return DOUBLE;
    }

    @Override
    public String[] possibleTypesForVariable (){
        return possibleTypesForVar;
    }

}
