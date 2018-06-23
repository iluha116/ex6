package main.Variables;

import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesExceptions.WrongCastingException;

/**
 * DoubleVariable class - Variable type Double
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class DoubleVariable extends Variable implements Cloneable {

    /**
     * Constructor
     * @param name name of the variable
     */
     DoubleVariable (String name, boolean hasValue){
        this.name = name;
        this.hasValue = hasValue;
        this.value = DEFAULT_VALUE;
        this.possibleTypesForVar = new String[]{INT,DOUBLE};
    }

    /**
     * Constructor with value
     * @param name name of the variable
     * @param value value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
     DoubleVariable (String name, String value) throws VariableException {
        this.name = name;
        this.possibleTypesForVar = new String[]{INT,DOUBLE};
        checkValue(value);
    }

    @Override
    public void checkValueAd (String value) throws WrongCastingException{
        try {
            double val = Double.parseDouble(value);
            setValue(value);
        }
        catch (Exception e){
            throw new WrongCastingException();
        }
    }

    @Override
    public String getType(){
        return DOUBLE;
    }


}
