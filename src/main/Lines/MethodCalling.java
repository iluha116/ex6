package main.Lines;
import main.*;
import main.Variables.Variable;
import java.util.*;

public class MethodCalling implements Line{
    private String[] parameters;
    private String name;

    /**
     *
     * @param name
     * @param parameters
     */
    public MethodCalling(String name,String[] parameters){
        this.parameters=parameters;
        this.name=name;
    }

    @Override
    public boolean isCorrect(Scope scope) throws IllegalLineException {
        if (!(scope instanceof Global)){
            for (Method method:scope.getMethods()){
                String[] methodTypes = method.getParametersTypes();
                if ((method.getName().equals(name)) && (methodTypes.length == parameters.length)){
                    String[] parametersTypes = checkParametersTypes(scope.getLocalVariables(),
                            scope.getGlobalVariables());
                    for (int i=0; i<methodTypes.length; i++){ // compare that all the types are similar.
                    }
                }
            }
        }
        throw new IllegalLineException();
    }

    /* Builds a String array of the types of the parameters that appear in the line,
    throws exception if there isn't such variable. */
    private String[] checkParametersTypes (ArrayList <Variable> valuesLocal, ArrayList <Variable> valuesGlobal)
            throws IllegalLineException{
        String [] types = new String[parameters.length];
        for (int i=0; i<parameters.length; i++){ // for each parameter in the line
            Variable var = findVariable(parameters[i], valuesLocal, valuesGlobal); // find the variable if exists
            types [i] = var.getType(); // save the type
        }
        return types;
    }

    /* Find the variable that is called in cur place in the line, throws exception if there isn't such variable */
    private Variable findVariable (String val, ArrayList <Variable> valuesLocal, ArrayList <Variable> valuesGlobal)
            throws IllegalLineException{
        // first, search in the local parameters
        for (int i=0; i<valuesLocal.size(); i++){
            Variable var = valuesLocal.get(i);
            if (var.getName().equals(val)){
                return var;
            }
        }
        // if doesn't found in the local parameters search in the global
        for (int i=0; i<valuesGlobal.size(); i++){
            Variable var = valuesGlobal.get(i);
            if (var.getName().equals(val)){
                return var;
            }
        }
        // if doesn't found in the local and global parameters
        throw new CallToUnExistsParameter();
    }


}
