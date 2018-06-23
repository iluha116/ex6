package main.Scopes.ScopeExceptions;

import main.Scopes.InnerScope;

/**
 * This class represents exception that thrown when some scope was defined without end.
 * (number of '{' are not equal to '}' )
 */
public class InnerScopeHasNoEnd extends ScopeException {
    /**
     * Constructor
     */
    public InnerScopeHasNoEnd(){
        message="Scope was defined without the end. E.g. '}' expected.";
    }
}
