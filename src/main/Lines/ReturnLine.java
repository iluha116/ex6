package main.Lines;
import main.Lines.LineExceptions.IllegalLineException;
import main.Lines.LineExceptions.ReturnException;
import main.Scopes.MethodScope;
import main.Scopes.Scope;
import java.util.ArrayList;

/**
 * This class represent return; line.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class ReturnLine extends Line {

    private static final int PRE_LAST_LINE = 2;

    /**
     * Constructor
     */
    public ReturnLine(){
    }

    @Override
    public void LineCorrectness (Scope scope) throws IllegalLineException {
        ArrayList<Line> lines = scope.getLines();
        if ((!(scope instanceof MethodScope))||(lines.get(lines.size()-PRE_LAST_LINE) == this)){
            // if exist not in method or not the pre last line of the method, it is wrong location.
            throw new ReturnException();
        }
    }
}
