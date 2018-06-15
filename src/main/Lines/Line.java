package main.Lines;
import main.Lines.LineExceptions.*;
import main.Scopes.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

/**
 * This class is Interface of Line of the code.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public abstract class Line {

    public abstract void LineCorrectness (Scope scope) throws IllegalLineException;

    public boolean startScope (){
        return false;
    }

    public boolean endScope (){
        return false;
    }

    /* Find the variable that is called in cur place in the line, throws exception if there isn't such variable */
    protected Variable findVariable (String val, ArrayList<Variable> valuesLocal, ArrayList <Variable> valuesGlobal)
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
