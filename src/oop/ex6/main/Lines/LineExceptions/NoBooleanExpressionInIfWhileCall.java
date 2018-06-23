package oop.ex6.main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when if/while statement was
 * is used with no boolean expression.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class NoBooleanExpressionInIfWhileCall extends IllegalLineException{
    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public NoBooleanExpressionInIfWhileCall(){
        message="illegal attempt to use if/while statement";
    }
}
