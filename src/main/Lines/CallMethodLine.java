package main.Lines;
import main.Lines.LineExceptions.*;
import main.Method;
import main.Scopes.Global;
import main.Scopes.Scope;
import main.Variables.Variable;

/**
 * This class represent call for method line.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class CallMethodLine extends Line{
    private String[] parameters;
    private String name;

    /**
     * Constructor
     * @param name name of the method that called.
     * @param parameters parameter name that are given for calling the method
     */
    public CallMethodLine(String name, String[] parameters){
        this.parameters=parameters;
        this.name=name;
    }

    @Override
    public void LineCorrectness (Scope scope) throws IllegalLineException {
        if (scope instanceof Global){ // can't be called from the global scope
            throw new CallMethodLineException();
        }
        if (!findSuitableMethod(scope)){ // of there isn't suitable method that can be called
            throw new CallMethodLineException();
        }
    }


   /* Finds if there is a suitable method for such call to method*/
    private boolean findSuitableMethod (Scope scope) throws IllegalLineException {
        for (Method method:scope.getMethods()){
            String[] methodTypes = method.getParametersTypes();
            if (method.getName().equals(name)){ // if the name found
                if (methodTypes.length != parameters.length){
                    // return false if the number of parameters is different
                    return false;
                }
                String[] parametersTypes = checkParametersTypes(scope);
                for (int i=0; i<methodTypes.length; i++){ // compare that all the types are similar.
                    if (parametersTypes[i].equals(methodTypes[i])){ // if the types different return false
                        return false;
                    }
                } // if the name and all the parameters types are similar:
                return true;
            }
        }
        // if gone over all methods and didn't find the suitable one
        return false;
    }

    /* Builds a String array of the types of the parameters that appear in the line,
    throws exception if there isn't such variable. */
    private String[] checkParametersTypes (Scope scope)
            throws IllegalLineException{
        String [] types = new String[parameters.length];
        for (int i=0; i<parameters.length; i++){ // for each parameter in the line
            // find the variable if exists
            Variable var = findVariable(parameters[i], scope);
            types [i] = var.getType();  // save the type
        }
        return types;
    }

}
