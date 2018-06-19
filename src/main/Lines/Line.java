package main.Lines;
import main.CodeException;
import main.Lines.LineExceptions.*;
import main.Scopes.Global;
import main.Scopes.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

/**
 * This class is Interface of Line of the code.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public abstract class Line {

    public abstract void LineCorrectness (Scope scope) throws CodeException;

    public boolean startScope (){
        return false;
    }

    public boolean endScope (){
        return false;
    }

    /* Find the variable that is called in cur place in the line, throws exception if there isn't such variable */
    protected Variable findVariable (String val, Scope scope)
            throws IllegalLineException{
        // first, search in the local parameters
        Variable variable;
        if (!(scope instanceof Global)){
            variable=findVariableInInsertedArray(val,scope.getLocalVariables());
                if (variable!=null){
                    return variable;
            }
        }
        // if doesn't found in the local parameters search in the global
        variable=findVariableInInsertedArray(val,scope.getGlobalVariables());
        if (variable!=null){
            return variable;
        }
        // if doesn't found in the local and global parameters
        throw new CallToUnExistsParameter();
    }


    protected Variable findVariableInInsertedArray(String val,ArrayList<Variable> listForSearch){
        Variable var=null;
        for (int i=0; i<listForSearch.size(); i++){
            var = listForSearch.get(i);
            if (var.getName().equals(val)){
                return var;
            }
        }
        return var;
    }


}
