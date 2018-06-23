package main.Lines;
import main.CodeException;
import main.Lines.LineExceptions.*;
import main.Scopes.Global;
import main.Scopes.MethodScope;
import main.Scopes.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

/**
 * This class is Interface of Line of the code.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public abstract class Line {
    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws CodeException exception that thrown in case that line is illegal.
     */
    public abstract void LineCorrectness (Scope scope) throws CodeException;


    /**
     * this method is verify if the line is the start of some scope
     * (e.g. the first line of the method or if/while statement. )
     * @return true if the line is the start of the scope,false otherwise. By default false will be returned.
     */
    public boolean startScope (){
        return false;
    }

    /**
     * this method is verify if the line is the end of some scope
     * (e.g. the last line of the method or if/while statement. )
     * @return true if the line is the end of the scope,false otherwise. By default false will be returned.
     */
    public boolean endScope (){
        return false;
    }


    /**
     * Find the variable that is called in cur place in the line, throws exception if there isn't such variable
     * @param val name of variable that have to be founded.
     * @param scope-scope where this variable is searched for.
     * @return Variable if there is some variables with searched name.
     * @throws CallToUnExistsParameter throw in case that there is no such variable.
     */
    protected Variable findVariable (String val, Scope scope) throws CallToUnExistsParameter{
        // first, search in the local parameters
        Variable variable;
        variable=findVariableInInsertedArray(val,scope.getLocalVariables());
        if (variable!=null){

            return variable;
        }
        // if doesn't found in the local parameters search in the global, if we are not in global
        if (!(scope instanceof Global)){
            variable=findVariableInInsertedArray(val,scope.getGlobalVariables());
            if (variable!=null){
                return variable;
            }
        }
        // if doesn't found in the local and global parameters
        throw new CallToUnExistsParameter();
    }


    /**
     * this method search the variable in some of arrays of scope.
     * @param val name of the variable that have to be founded.
     * @param listForSearch -array where the variable is searched for.
     * @return variable if there is appropriate,null otherwise.
     */
    protected Variable findVariableInInsertedArray(String val,ArrayList<Variable> listForSearch){
        Variable variable=null;
        for (int i=0; i<listForSearch.size(); i++){
            String varName = listForSearch.get(i).getName();
            if (varName.equals(val)){
                variable = listForSearch.get(i);
                return variable;
            }
        }
        return variable;
    }

}
