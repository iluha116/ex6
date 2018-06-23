package oop.ex6.main.Scopes;
import oop.ex6.main.CodeException;
import oop.ex6.main.Lines.*;
import oop.ex6.main.Method;
import oop.ex6.main.Scopes.ScopeExceptions.*;
import oop.ex6.main.Variables.*;
import java.util.*;

/**
 * Abstract of scope.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

abstract public class Scope {

    /*array of methods in the global scope*/
    protected ArrayList<Method> methods;
    /*array of lines in the current scope*/
    protected ArrayList<Line> lines;
    /*array of local variables in the current scope*/
    protected ArrayList<Variable> localVariables;
    /*array of local variables that was defined without value in the current scope*/
    protected ArrayList<Variable> timeVariables;
    /*array of local variables that was defined without value and cant
    get value any more in the current scope*/
    protected ArrayList<Variable> garbageVariables;
    /*pointer to the current line we checks*/
    protected int cur=0;

    /**
     * @return array of lines in the current scope
     */
    public ArrayList<Line> getLines (){
        return lines;
    }

    /**
     * @return array of methods in the global scope
     */
    public ArrayList<Method> getMethods (){
        return methods;
    }

    /**
     * @return array of global variables in the current scope
     */
    public ArrayList<Variable> getGlobalVariables (){
        return localVariables;
    }

    /**
     * @return array of local variables in the current scope
     */
    public ArrayList<Variable> getLocalVariables (){
        return localVariables;
    }

    /**
     * Check that all the lines of the scope are legal
     * @throws CodeException throws if there is some problem with the lines in the scope
     */
    public abstract void scopeCorrectness() throws CodeException;

    /**
     * Finds Inner Scope lines
     * @param start line that is a start new scope line
     * @param all all lines of the scope we work on
     * @return ArrayList<Line> for the new Inner scope
     */
    protected ArrayList<Line> findScope (Line start, ArrayList<Line> all) throws InnerScopeHasNoEnd{
        ArrayList<Line> scopeLines = new ArrayList<>();
        int curLineNum = all.indexOf(start);
        Line cur = start;
        scopeLines.add(cur);
        int numOpen = 1;
        int numClose = 0;
        while (!(numClose== numOpen)){ // while number of opening scope lines not equals to end scope lines.
            try{
                curLineNum += 1;
                cur = all.get(curLineNum);
                scopeLines.add(cur);
                if (cur.startScope()){
                    numOpen += 1;
                }
                if (cur.endScope()){
                    numClose += 1;
                }
            } // if we get out of the all ArrayList, mean the scope has no end
            catch (Exception e){
                throw new InnerScopeHasNoEnd();
            }
        }
        return scopeLines;
    }

    /**
     * @return array of local variables that was defined without value and cant
     * get value any more in the current scope.
     */
    public ArrayList<Variable> getGarbageVariables() {
        return garbageVariables;
    }

    /**
     * @return array of local variables that was defined without value in the current scope
     */
    public ArrayList<Variable> getTimeVariables() {
        return timeVariables;
    }

    /**
     * Move Time Variable to local Variables
     * @param var Variable to remove
     */
    public void removeFromTimeVariables(Variable var) {
        timeVariables.remove(var);
        localVariables.add(var);
    }

    /**
     * updates the method ArrayList of the scope - add the new method
     * @param method Method for add
     * @throws RepeatMethodName throws if try to add method with the same name
     */
    public void updateMethods (Method method) throws RepeatMethodName{
        for (Method met:methods){ // check if there isn't already method with such name
            if (met.getName().equals(method.getName())){
                throw new RepeatMethodName();
            }
        }
        methods.add(method);
    }

    /**
     * Updates the variables
     * @param defaultVariables new variables without value
     * @param nonDefaultVariables new variables with value
     */
    public abstract void updateVariables (ArrayList<Variable> defaultVariables,
                                          ArrayList<Variable> nonDefaultVariables) ;

    /**
     * Deepcopy of ArrayList of Variable
     * @param forCopy ArrayList of variables for copy
     * @return the new copy
     */
    public ArrayList<Variable> deepCopy (ArrayList<Variable> forCopy){
        ArrayList<Variable> copy = new ArrayList<>();
        for (Variable var: forCopy){ // for all variables in the arrayList clone
            Variable newVar = var.clone();
            copy.add(newVar);
        }
        return copy;
    }

}
