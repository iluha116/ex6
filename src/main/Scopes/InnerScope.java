package main.Scopes;

import main.CodeException;
import main.Lines.IfWhileLine;
import main.Lines.Line;
import main.Lines.MethodLine;

import java.util.ArrayList;

/**
 * This class represent the inner scopes in the code.
 * That can be inside the global scope.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */


public abstract class InnerScope extends Scope{

    @Override
    public void scopeCorrectness() throws CodeException {
        ArrayList<ArrayList<Line>> curScope = new ArrayList<>();
        int cur = 0;
        while ( cur < lines.size()){
            Line curLine = lines.get(cur);
            curLine.LineCorrectness(this);
            if (curLine instanceof IfWhileLine){ // if the line defines if while scope
                cur = super.findScope(curLine, lines, curScope);
                ArrayList<Line> scopeForCheckLines = curScope.get(0);
                IfWhileScope scopeForCheck = new IfWhileScope (globalVariables, methods, scopeForCheckLines);
                scopeForCheck.scopeCorrectness();
                curScope.remove(0);
            }
            else{
                cur += 1; // if had no scope move forward one line
            }
            // updates for variables?
        }
    }

}
