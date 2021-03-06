package oop.ex6.main.Variables;
import oop.ex6.main.Variables.VariablesExceptions.*;

/**
 * this class represents Variables Factory class
 * @author Shani Cheskis
 * @author Ilia Bogov
 */


public class VariablesFactory {

    // types
    private static final String STRING = "String";
    private static final String INT = "int";
    private static final String DOUBLE = "double";
    private static final String BOOLEAN = "boolean";
    private static final String CHAR = "char";

    /**
     * Factory
     * @param type type of the variable
     * @param name name of the variable
     * @param ifFinal boolean if the variable final
     * @return Variable object
     * @throws VariableException if cant create such variable
     */
    public static Variable factory (String type, String name, String value, boolean ifFinal)
            throws VariableException{
        Variable val;
        if (!Variable.checkName(name)){
            // checks if the name suitable
            throw new NoTypeOfVariable();
        }
        switch (type){
            case (STRING):
                val = new StringVariable (name,value);
                break;
            case (INT):
                val = new IntVariable (name,value);
                break;
            case (DOUBLE):
                val = new DoubleVariable (name,value);
                break;
            case (BOOLEAN):
                val = new BooleanVariable (name,value);
                break;
            case (CHAR):
                val = new CharVariable (name,value);
                break;
            default: // another type impossible
                throw new NoTypeOfVariable();
        }
        if (ifFinal){
            val=new FinalVariable(val);
        }
        return val;
    }

    /**
     * Default Factory - assume that the given type exists and give default values
     * @param type type of the variable
     * @param name name of the variable
     * @param ifFinal boolean if the variable final
     * @return Variable object
     */
    public static Variable factoryDefault (String type, String name, boolean ifFinal, boolean hasValue) {
        Variable val;
        switch (type){
            case (STRING):
                val = new StringVariable (name, hasValue);
                break;
            case (INT):
                val = new IntVariable (name, hasValue);
                break;
            case (DOUBLE):
                val = new DoubleVariable (name, hasValue);
                break;
            case (BOOLEAN):
                val = new BooleanVariable (name, hasValue);
                break;
            default: // assume (CHAR)
                val = new CharVariable (name, hasValue);
                break;
        }
        if (ifFinal){
            val=new FinalVariable(val);
        }

        return val;
    }



}
