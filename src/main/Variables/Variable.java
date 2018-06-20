package main.Variables;

import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesExceptions.WrongCastingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * interface Variable
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public abstract class Variable implements Cloneable {

    protected String name;
    protected boolean hasValue;
    protected String value;
    protected boolean varValue = false;
    protected static final String DEFAULT_VALUE = "";
    protected static final Pattern VAR_AS_VALUE = Pattern.compile("[A-Za-z]+\\w*|_+\\w+");

    /**
     * Sets the given value to the variable, if can't throws WrongCastingException
     * @param value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
    public void checkValue (String value) throws VariableException{
        if (checkName(value)){ // check if
            setValue(value);
            varValue = true;
        }
        else {
            checkValueAd (value);
        }
    }

    protected abstract void checkValueAd (String value) throws VariableException;

    protected void setValue (String value){
        this.hasValue = true;
        this.value = value;
    }

    public String getName (){
        return name;
    }

    public abstract String getType();

    public boolean hasValue() {
        return hasValue;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Variable clone (){
        return VariablesFactory.factoryDefault(this.getType(),name, hasValue,hasValue);
    }

    public static boolean checkName (String name){
        Matcher mat=VAR_AS_VALUE.matcher(name);
        return mat.matches();
    }




}
