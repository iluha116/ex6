package oop.ex6.main.Scopes;
import oop.ex6.main.CodeException;
import oop.ex6.main.Lines.*;
import oop.ex6.main.Method;
import oop.ex6.main.Variables.Variable;
import java.util.ArrayList;

/**
 * This class represent the if and while scopes.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class IfWhileScope extends InnerScope {

    /**
     * Constructor
     * @param globals ArrayList of globals parameters for the Scope
     * @param methods ArrayList of methods available for calling
     * @param lines ArrayList of lines in the current scope
     */
    public IfWhileScope (ArrayList<Variable> globals, ArrayList<Method> methods, ArrayList<Line> lines){
        this.lines = lines;
        this.globalVariables = globals;
        this.localVariables = new ArrayList<>();
        this.garbageVariables = new ArrayList<>();
        this.timeVariables = new ArrayList<>();
        this.methods = methods;
    }

    @Override
    public void scopeCorrectness() throws CodeException {
        super.scopeCorrectness();
    }

}
