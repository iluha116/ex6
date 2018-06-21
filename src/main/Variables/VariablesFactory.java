package main.Variables;
import main.Variables.VariablesExceptions.*;

/**
 * Variables Factory class
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
     * @param IfFinal boolean if the variable final
     * @return Variable object
     * @throws VariableException if cant create such variable
     */
    public static Variable factory (String type, String name, String value, boolean IfFinal)
            throws VariableException{
        Variable val;
        if (!Variable.checkName(name)){
            // checks if the name suitable
            throw new NoTypeOfVariable();
        }
        switch (type){
            case (STRING):
                val = new StringVariable (name,value,IfFinal);
                break;
            case (INT):
                val = new IntVariable (name,value,IfFinal);
                break;
            case (DOUBLE):
                val = new DoubleVariable (name,value,IfFinal);
                break;
            case (BOOLEAN):
                val = new BooleanVariable (name,value,IfFinal);
                break;
            case (CHAR):
                val = new CharVariable (name,value,IfFinal);
                break;
            default: // another type impossible
                throw new NoTypeOfVariable();
        }
        return val;
    }

    /**
     * Default Factory - assume that the given type exists and give default values
     * @param type type of the variable
     * @param name name of the variable
     * @param IfFinal boolean if the variable final
     * @return Variable object
     */
    public static Variable factoryDefault (String type, String name, boolean IfFinal, boolean hasValue) {
        Variable val;
        switch (type){
            case (STRING):
                val = new StringVariable (name, hasValue, IfFinal);
                break;
            case (INT):
                val = new IntVariable (name, hasValue, IfFinal);
                break;
            case (DOUBLE):
                val = new DoubleVariable (name, hasValue, IfFinal);
                break;
            case (BOOLEAN):
                val = new BooleanVariable (name, hasValue, IfFinal);
                break;
            default: // assume (CHAR)
                val = new CharVariable (name, hasValue, IfFinal);
                break;
        }
        return val;
    }



}
