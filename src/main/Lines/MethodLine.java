package main.Lines;
import main.Lines.LineExceptions.IllegalLineException;
import main.Method;
import main.Scopes.Global;
import main.Scopes.MethodScope;
import main.Scopes.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public class MethodLine extends Line {

    private Method method;
    private static final String SPACE = " ";
    private static final int NO_FINAL = 2;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;


    /**
     * Constructor
     * @param name name of the method
     * @param variables array string of the parameters for the method
     */
    public MethodLine (String name, String[] variables){
        String[] types = new String[variables.length];
        String[] names = new String[variables.length];
        boolean [] ifFinal = new boolean[variables.length];
        for (int i=0; i<variables.length; i++){
            String[] pair = variables[i].split(SPACE); // parameters of the cur variable
            if (pair.length == NO_FINAL){ // if has not final
                types[i] = pair[FIRST];
                names[i] = pair[SECOND];
                ifFinal[i]= false;
            }
            else{ // if has final (length 3)
                types[i] = pair[SECOND];
                names[i] = pair[THIRD];
                ifFinal[i]= true;
            }
        }
        this.method = new Method(name,names,types,ifFinal);
    }

    @Override
    public void LineCorrectness (Scope scope) throws IllegalLineException {
        if (scope instanceof Global){ // can be only in the global Scope
            updateMethods (scope);
        }
        throw new IllegalLineException();
    }

    /* updates the method ArrayList of the scope - add the new method */
    private void updateMethods (Scope scope){
        ArrayList<Method> methods = scope.getMethods();
        methods.add(method);
    }

    /**
     * Updates the local variables of MethodScope according to the call line.
     * @param scope MethodScope
     */
    public void updateVariablesStartMethod (MethodScope scope) {
        ArrayList<Variable> local = scope.getLocalVariables();
        // creates all the variables that are given in the method call
        ArrayList<Variable> methodVars = method.createVariables();
        local.addAll(methodVars); // add them to the local variables
    }

    @Override
    public boolean startScope() {
        return true;
    }
}
