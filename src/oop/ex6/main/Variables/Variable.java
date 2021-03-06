package oop.ex6.main.Variables;

import oop.ex6.main.CodeException;
import oop.ex6.main.Variables.VariablesExceptions.ChangeFinalVariableException;
import oop.ex6.main.Variables.VariablesExceptions.VariableException;
import oop.ex6.main.Variables.VariablesExceptions.WrongCastingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * interface Variable
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public abstract class Variable implements Cloneable {

    // types
    protected static final String STRING = "String";
    protected static final String INT = "int";
    protected static final String DOUBLE = "double";
    protected static final String BOOLEAN = "boolean";
    protected static final String CHAR = "char";

    /*name of the variable. */
    protected String name;
    /*if the variable has some value . */
    protected boolean hasValue= false;
    /*value of the variable .*/
    protected String value;
    /*if the value is some other defined variable. */
    protected boolean varValue = false;
    /*default value for variable. */
    protected static final String DEFAULT_VALUE = "";
    /*pattern for verifying that name of variable is appropriate and check if value of variable is other value.
    /*will be checked if value is appropriate for the pattern and if yes will be checked if such variable exists. */
    protected static final Pattern VAR_AS_VALUE = Pattern.compile("[A-Za-z]+\\w*|_+\\w+");
    /*appropriate types of variables. */
    protected String [] possibleTypesForVar;

    /**
     * Sets the given value to the variable, if can't throws WrongCastingException
     * @param value for the variable
     * @throws WrongCastingException if the value doesn't fit the type of the variable throws exception
     */
    public void checkValue (String value) throws VariableException{
        try{
            checkValueAd (value);
        }
        catch (VariableException e){
            if (checkName(value)){ // check if
                this.hasValue = false;
                this.value = value;
                varValue = true;
            }
            else{
                throw e;
            }
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
        Variable var=VariablesFactory.factoryDefault(this.getType(),this.getName(), this.isFinal(), this.hasValue());
        var.setValue(this.getValue());
        return var;
    }

    public boolean isFinal(){
        return false;
    }

    public static boolean checkName (String name){
        Matcher mat = VAR_AS_VALUE.matcher(name);
        return mat.matches();
    }

    public boolean hasVariableValue (){
        return this.varValue;
    }

    /**
     * @return valid types of variables,legal for assignment.
     */
    public String[] possibleTypesForVariable (){
        return this.possibleTypesForVar;
    }

}
