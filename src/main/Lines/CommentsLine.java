package main.Lines;

import main.Lines.LineExceptions.IllegalLineException;
import main.Scopes.Scope;

/**
 * This class represent comment and empty lines.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class CommentsLine extends Line {

    /**
     * Constructor
     */
    public CommentsLine (){
    }

    @Override
    public void LineCorrectness (Scope scope) throws IllegalLineException {
    }

}
