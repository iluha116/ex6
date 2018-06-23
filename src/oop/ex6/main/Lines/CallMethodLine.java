package oop.ex6.main.Lines;
import oop.ex6.main.Lines.LineExceptions.*;
import oop.ex6.main.Method;
import oop.ex6.main.Scopes.*;
import oop.ex6.main.Variables.*;
import oop.ex6.main.Variables.VariablesExceptions.VariableException;

/**
 * This class represent call for method line.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class CallMethodLine extends Line{
    /* function is called with those parameters. */
    private String[] parameters;
    /* name of the function that is called. */
    private String name;
    /* default parameters for trying create a variable */
    private final String TRY_NAME= "name";
    private final boolean TRY_FINAL= false;

    /**
     * Constructor for line that call some method.
     * @param name name of the method that called.
     * @param parameters parameter name that are given for calling the method
     */
    public CallMethodLine(String name, String[] parameters){
        this.parameters=parameters;
        this.name=name.trim();
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
        if (!findSuitableMethod(scope)){ // if there isn't suitable method that can be called
            throw new CallMethodLineException();
        }
    }

    /**
     * Finds if there is a suitable method for such call to method.
     * @param scope-scope that contain array of all existed function. In this array function will be searched.
     * @return true if such method is exists,false otherwise.
     * method was called with not appropriate parameters.
     */
    private boolean findSuitableMethod (Scope scope) {
        for (Method method:scope.getMethods()){
            String[] methodTypes = method.getParametersTypes();
            if (method.getName().equals(name)){ // if the name found
                if (methodTypes.length != parameters.length){
                    // return false if the number of parameters is different
                    return false;
                } // else
                if (checkParametersTypes(scope,methodTypes)) {
                    // if the name and all the parameters types are similar:
                    return true;
                }
            }
        }
        // if gone over all methods and didn't find the suitable one
        return false;
    }


    /**
     * this method checks if all the given parameters types is the same in the methodTypes
     * @param scope-scope that contains all variables.
     * @param methodTypes list of parameters types
     * @return array of types.
     * method was called with not appropriate parameters.
     */
    private boolean checkParametersTypes (Scope scope,  String[] methodTypes) {
        for (int i=0; i<methodTypes.length; i++){ // for each parameter in the method
            try {
                // try to find variable that can be the given parameter
                Variable var = findVariable(parameters[i], scope);

                if (!var.getType().equals(methodTypes[i])){ // if the different types
                    return false;
                }
            }
            catch (CallToUnExistsParameter e){// if there isn't variable, it can be a value in the needed type
                try {
                    Variable tryVar = VariablesFactory.factory(methodTypes[i], TRY_NAME,
                            parameters[i].trim(), TRY_FINAL);
                    if (!tryVar.hasValue()){ // if the parameter has no value can't be send
                        return false;
                    }
                }
                catch (VariableException ex){
                    return false;
                }
            }
        }
        return true;
    }

}
