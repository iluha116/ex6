package main.Scopes;
import main.CodeException;
import main.Lines.*;
import main.Method;
import main.Variables.Variable;
import java.util.ArrayList;

/**
 * This class represent the method scope.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */


public class MethodScope extends Scope {

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
        this.methods = methods;
    }

    @Override
    public void scopeCorrectness() throws CodeException {
    }
}
