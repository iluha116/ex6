package main.Lines;
import main.Lines.LineExceptions.IllegalLineException;
import main.Scopes.*;
import java.util.ArrayList;

/**
 * This class represent } line (end of an InnerScope).
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class EndScope extends Line {

    /**
     * Constructor
     */
    public EndScope (){
    }

    @Override
    public void LineCorrectness (Scope scope) throws IllegalLineException {
        ArrayList<Line> lines = scope.getLines();
        if ((scope instanceof Global)||(lines.get(lines.size()-1)== this)){
            // if not the last line in not InnerScope
            throw new IllegalLineException();
        }
    }

    @Override
    public boolean endScope() {
        return true;
    }
}
