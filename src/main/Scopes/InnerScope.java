package main.Scopes;

import main.CodeException;
import main.Lines.*;
import main.Variables.Variable;
import java.util.ArrayList;

/**
 * This class represent the inner scopes in the code.
 * That can be inside the global scope.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */


public abstract class InnerScope extends Scope{


    /* variables from the upper scope*/
    protected ArrayList<Variable> globalVariables;
    /* if need to clear the time variables (local without value)*/
    protected boolean timeVariablesDelete = true;

    @Override
    public ArrayList<Variable> getGlobalVariables (){
        return globalVariables;
    }

    @Override
    public void updateVariables (ArrayList<Variable> defaultVariables, ArrayList<Variable> nonDefaultVariables){
        timeVariablesDelete = false;
        localVariables.addAll(nonDefaultVariables); // new variables with value add to local
        timeVariablesDeletion();
        timeVariables = defaultVariables;
    }

    /* deletes time variables (local without value), move them to garbge values*/
    private void timeVariablesDeletion (){
        garbageVariables.addAll(timeVariables);
        timeVariables.clear();
    }

    @Override
    public void scopeCorrectness() throws CodeException {
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
            }
            else {
                cur += 1; // if had no scope move forward one line
            }
            if (timeVariablesDelete) { // wasn't delete already
                timeVariablesDeletion();
            }
        }
    }



}
