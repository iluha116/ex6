package oop.ex6.main.Lines.LineExceptions;

/**
 * This class represents exception thrown in cases when
 * final variable was defined without value.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class FinalHasNoValue extends IllegalLineException {
    /**
     * Constructor
     */
    public FinalHasNoValue(){
        message="attempt to define final variable without value.";
    }
}
