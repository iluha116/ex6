package main.Scopes;
import main.CodeException;
import main.Lines.Line;
import main.Lines.MethodLine;
import main.Variables.Variable;

import java.util.ArrayList;

/**
 * This class represent the global scope of the code.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class Global extends Scope {

    /**
     * Constructor
     * @param lines ArrayList of lines in the current scope
     */
    public Global (ArrayList<Line> lines){
        this.lines = lines;
        this.localVariables = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.timeVariables=null;
        this.garbageVariables=null;
    }

    public  void updateVariables (ArrayList<Variable> defaultVariables, ArrayList<Variable> nonDefaultVariables){
        localVariables.addAll(nonDefaultVariables);
        localVariables.addAll(defaultVariables);
    }

    @Override
    public void scopeCorrectness() throws CodeException {
        ArrayList<ArrayList<Line>> methodsLines = new ArrayList<>();
        int cur = 0;
        while ( cur < lines.size()){
            Line curLine = lines.get(cur);
            curLine.LineCorrectness(this);
            if (curLine instanceof MethodLine){ // if the line defines method
                ArrayList<Line> curMethod = super.findScope(curLine, lines);
                methodsLines.add(curMethod);
                cur += curMethod.size();
            }
            else{
                cur += 1; // if had no scope move forward one line
            }
            // updates for variables?
        }
        // check correctness of all methods
         for (ArrayList<Line> method : methodsLines){
            MethodScope methodForCheck = new MethodScope(deepCopy(localVariables), methods, method);
            methodForCheck.scopeCorrectness();
         }
    }
}
