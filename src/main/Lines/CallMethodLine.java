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
    /*function is called with those parameters. */
    private String[] parameters;
    /*name of the function that is called. */
    private String name;

    /**
     * Constructor for line that call some method.
     * @param name name of the method that called.
     * @param parameters parameter name that are given for calling the method
     */
    public CallMethodLine(String name, String[] parameters){
        this.parameters=parameters;
        this.name=name;
    }

    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws IllegalLineException exception that thrown in case that line is illegal.
     */
    @Override
    public void LineCorrectness (Scope scope) throws IllegalLineException {
        if (scope instanceof Global){ // can't be called from the global scope
            throw new CallMethodLineException();
        }
        if (!findSuitableMethod(scope)){ // of there isn't suitable method that can be called
            throw new CallMethodLineException();
        }
    }


    /**
     * Finds if there is a suitable method for such call to method.
     * @param scope-scope that contain array of all existed function. In this array function will be searched.
     * @return true if such method is exists,false otherwise.
     * @throws IllegalLineException  exception that thrown in case that
     * method was called with not appropriate parameters.
     */
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



    /**
     * this method is verify types of variables.
     * @param scope-scope that contains all variables.
     * @return array of types.
     * @throws IllegalLineException exception that thrown in case that
     * method was called with not appropriate parameters.
     */
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
