package main.Scopes;

import main.CodeException;
import main.Lines.DefiningVariableLine;
import main.Lines.IfWhileLine;
import main.Lines.Line;
import main.Lines.MethodLine;
import main.Variables.Variable;

import java.util.ArrayList;

/**
 * This class represent the inner scopes in the code.
 * That can be inside the global scope.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */


public abstract class InnerScope extends Scope{


    protected ArrayList<Variable> globalVariables;
    protected boolean timeVariablesDelete = true;

    @Override
    public ArrayList<Variable> getGlobalVariables (){
        return globalVariables;
    }


    public void updateVariables (ArrayList<Variable> defaultVariables, ArrayList<Variable> nonDefaultVariables){
        timeVariablesDelete = false;
        localVariables.addAll(nonDefaultVariables); // new variables with value add to local
        timeVariablesDeletion();
        timeVariables = defaultVariables;
    }

    protected void timeVariablesDeletion (){
        garbageVariables.addAll(timeVariables); //
        timeVariables.clear();
    }

    @Override
    public void scopeCorrectness() throws CodeException {
        try {
            cur = 1;
            while (cur < lines.size()) {
                timeVariablesDelete = true;
                Line curLine = lines.get(cur);
                curLine.LineCorrectness(this);
                if (curLine instanceof IfWhileLine) { // if the line defines if while scope
                    ArrayList<Line> scopeForCheckLines = super.findScope(curLine, lines);
                    cur += scopeForCheckLines.size();
                    ArrayList<Variable> deepcopy = deepCopy(globalVariables);
                    deepcopy.addAll(localVariables);
                    IfWhileScope scopeForCheck = new IfWhileScope(deepcopy, methods, scopeForCheckLines);
                    scopeForCheck.scopeCorrectness();
                } else {
                    cur += 1; // if had no scope move forward one line
                }
                if (timeVariablesDelete) { // wasn't delete already
                    timeVariablesDeletion();
                }
            }
        }
        catch (Exception e){
            System.out.println("!!!");
            System.out.println(this.getClass());
            System.out.println(cur);
            throw e;
        }
    }



}
