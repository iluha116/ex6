package main.Scopes;
import main.CodeException;
import main.Lines.Line;
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
        this.globalVariables = new ArrayList<>();
        this.localVariables = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.timeVariables=null;
        this.garbageVariables=null;
    }

    @Override
    public void scopeCorrectness() throws CodeException {
    }
}
