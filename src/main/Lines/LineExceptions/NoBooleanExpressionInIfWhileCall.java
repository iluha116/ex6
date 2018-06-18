package main.Lines.LineExceptions;

public class NoBooleanExpressionInIfWhileCall extends IllegalLineException{
    public NoBooleanExpressionInIfWhileCall(){
        message="illegal attempt to use if/while statement";
    }
}
