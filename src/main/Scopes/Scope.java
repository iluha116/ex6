package main.Scopes;
import main.CodeException;
import main.Lines.*;
import main.Method;
import main.Scopes.ScopeExceptions.*;
import main.Variables.*;
import java.util.*;

abstract public class Scope {

    protected ArrayList<Method> methods;
    protected ArrayList<Line> lines;
    protected ArrayList<Variable> localVariables;
    protected ArrayList<Variable> timeVariables;
    protected ArrayList<Variable> garbageVariables;
    protected int cur=0;

    public ArrayList<Line> getLines (){
        return lines;
    }

    public ArrayList<Method> getMethods (){
        return methods;
    }

    public ArrayList<Variable> getGlobalVariables (){
        return localVariables;
    }

    public ArrayList<Variable> getLocalVariables (){
        return localVariables;
    }

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

    public ArrayList<Variable> getGarbageVariables() {
        return garbageVariables;
    }

    public ArrayList<Variable> getTimeVariables() {
        return timeVariables;
    }

    public void removeFromTimeVariables(Variable var) {
        try{
            timeVariables.remove(var);
            localVariables.add(var);
        }
        catch (NullPointerException e){
            //System.out.println("timeVariables are empty.");
        }
    }

    /* updates the method ArrayList of the scope - add the new method */
    public void updateMethods (Method method) throws ReapeatMethodName{
        for (Method met:methods){ // check if there isn't already method with such name
            if (met.getName().equals(method.getName())){
                throw new ReapeatMethodName();
            }
        }
        methods.add(method);
    }

    public abstract void updateVariables (ArrayList<Variable> defaultVariables,
                                          ArrayList<Variable> nonDefaultVariables) ;

    public ArrayList<Variable> deepCopy (ArrayList<Variable> forCopy){
        ArrayList<Variable> copy = new ArrayList<>();
        for (Variable var: forCopy){
            Variable newVar = var.clone();
            copy.add(newVar);
        }
        return copy;
    }

}
