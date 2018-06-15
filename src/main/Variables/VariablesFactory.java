package main.Variables;
import main.Variables.VariablesExceptions.*;

/**
 * Variables Factory class
 * @author Shani Cheskis
 * @author Ilia Bogov
 */


public class VariablesFactory {


    public static final String STRING = "String";
    public static final String INT = "int";
    public static final String DOUBLE = "double";
    public static final String BOOLEAN = "boolean";
    public static final String CHAR = "char";

    /**
     * Constructor
     * @param type type of the variable
     * @param name name of the variable
     * @param IfFinal boolean if the variable final
     * @return Variable object
     * @throws NoTypeOfVariable
     */
    public static Variable factory (String type, String name, String value, boolean IfFinal)
            throws VariableException{
        Variable val;
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
            default:
                throw new NoTypeOfVariable();
        }
        if (IfFinal){
            val = new FinalVariable(val);
        }
        return val;
    }

    /**
     * Default constructor - assume that the given type exists and give default values
     * @param type type of the variable
     * @param name name of the variable
     * @param IfFinal boolean if the variable final
     * @return Variable object
     */
    public static Variable factoryDefault (String type, String name, boolean IfFinal) {
        Variable val;
        switch (type){
            case (STRING):
                val = new StringVariable (name);
                break;
            case (INT):
                val = new IntVariable (name);
                break;
            case (DOUBLE):
                val = new DoubleVariable (name);
                break;
            case (BOOLEAN):
                val = new BooleanVariable (name);
                break;
            default: // assume (CHAR)
                val = new CharVariable (name);
                break;
        }
        if (IfFinal){
            val = new FinalVariable(val);
        }
        return val;
    }

}
