package oop.ex6.main.Scopes;
import oop.ex6.main.CodeException;
import oop.ex6.main.Lines.*;
import oop.ex6.main.Method;
import oop.ex6.main.Variables.Variable;
import java.util.ArrayList;

/**
 * This class represent the method scope.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */


public class MethodScope extends InnerScope {

    /* first line index */
    private static final int FIRST_LINE = 0;
    /**
     * Constructor
     * @param globals ArrayList of globals parameters for the Scope
     * @param methods ArrayList of methods available for calling
     * @param lines ArrayList of lines in the current scope
     */
    public MethodScope (ArrayList<Variable> globals, ArrayList<Method> methods, ArrayList<Line> lines){
        this.lines = lines;
        this.globalVariables = globals;
        this.localVariables = new ArrayList<>();
        this.garbageVariables = new ArrayList<>();
        this.timeVariables = new ArrayList<>();
        this.methods = methods;
    }

    @Override
    public void scopeCorrectness() throws CodeException {
        Line first = lines.get(FIRST_LINE); // check first line again, in order to get the variables from it
        first.LineCorrectness(this);
        super.scopeCorrectness();
    }
}
