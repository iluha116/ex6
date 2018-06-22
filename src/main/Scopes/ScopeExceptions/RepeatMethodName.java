package main.Scopes.ScopeExceptions;

/**
 * This class represents exception thrown in case when Two methods was defined with the same name.
 */
public class RepeatMethodName extends ScopeException  {
    /**
     * Constructor
     */
    public RepeatMethodName(){
        message="Was defined two methods with the same name";
    }
}
