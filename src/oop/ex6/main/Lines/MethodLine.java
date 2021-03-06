package oop.ex6.main.Lines;
import oop.ex6.main.CodeException;
import oop.ex6.main.Lines.LineExceptions.DefiningExistedVariableException;
import oop.ex6.main.Lines.LineExceptions.IllegalLineException;
import oop.ex6.main.Lines.LineExceptions.MethodCreatingException;
import oop.ex6.main.Method;
import oop.ex6.main.Scopes.Global;
import oop.ex6.main.Scopes.MethodScope;
import oop.ex6.main.Scopes.Scope;
import oop.ex6.main.Variables.Variable;

import java.util.ArrayList;
import java.util.HashSet;

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
    public MethodLine (String name, String[] variables) throws DefiningExistedVariableException{
        String[] types = new String[variables.length];
        String[] names = new String[variables.length];
        HashSet<String> namesCheck = new HashSet<>();
        boolean [] ifFinal = new boolean[variables.length];
        for (int i=0; i<variables.length; i++){
            String[] pair = variables[i].split(SPACE); // parameters of the cur variable
            if (pair.length == NO_FINAL){ // if has not final
                types[i] = pair[FIRST];
                if (namesCheck.contains(pair[SECOND])){
                    // checks if there wasn't defined already in the line variable with that name
                    throw new DefiningExistedVariableException();
                }
                names[i] = pair[SECOND];
                ifFinal[i]= false;
            }
            else{ // if has final (length 3)
                types[i] = pair[SECOND];
                if (namesCheck.contains(pair[THIRD])){
                    // checks if there wasn't defined already in the line variable with that name
                    throw new DefiningExistedVariableException();
                }
                names[i] = pair[THIRD];
                ifFinal[i]= true;
            }
            namesCheck.add(names[i]);
        }
        this.method = new Method(name,names,types,ifFinal);
    }


    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws IllegalLineException -exception that thrown in case that function is created inside other function.
     */
    @Override
    public void LineCorrectness (Scope scope) throws CodeException {
        if ((scope instanceof MethodScope)&&(scope.getLines().get(0) == this)){
            // if it is Method scope and the first line, need to update the parameters as local in the scope
            updateVariablesStartMethod(scope);
            return;
        }
        if (!(scope instanceof Global)){ // can be only in the global Scope
            throw new MethodCreatingException();
        }
        scope.updateMethods (method); // updates the ArrayList of the Global scope
    }

    /*
     * Updates the local variables of MethodScope according to the call line.
     */
    private void updateVariablesStartMethod (Scope scope) throws CodeException {
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
