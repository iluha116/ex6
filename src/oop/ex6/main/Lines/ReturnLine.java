package oop.ex6.main.Lines;
import oop.ex6.main.Lines.LineExceptions.IllegalLineException;
import oop.ex6.main.Lines.LineExceptions.ReturnException;
import oop.ex6.main.Scopes.MethodScope;
import oop.ex6.main.Scopes.Scope;
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
        if ((!(scope instanceof MethodScope))||!(lines.get(lines.size()-PRE_LAST_LINE).equals(this))){
            // if exist not in method or not the pre last line of the method, it is wrong location.
            throw new ReturnException();
        }
    }
}
