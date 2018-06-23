package main.Lines;
import main.Lines.LineExceptions.EndScopeException;
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
     * Constructor that creates  line that contain char '}';
     */
    public EndScope (){
    }

    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws IllegalLineException
     */
    @Override
    public void LineCorrectness (Scope scope) throws IllegalLineException {
        ArrayList<Line> lines = scope.getLines();
        if ((scope instanceof Global)||(!(lines.get(lines.size()-1).equals(this)))){
            // if not the last line in not InnerScope
            throw new EndScopeException();
        }
    }

    /**
     *
     * @return true because it is the last line of some of the scopes.
     */
    @Override
    public boolean endScope() {
        return true;
    }
}
