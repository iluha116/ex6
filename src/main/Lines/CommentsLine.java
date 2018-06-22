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
     * Constructor of comments line
     */
    public CommentsLine (){
    }

    /*this line will not be checked. */
    @Override
    public void LineCorrectness (Scope scope){
    }

}
