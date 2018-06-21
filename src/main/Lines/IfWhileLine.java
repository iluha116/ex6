package main.Lines;
import main.Lines.LineExceptions.*;
import main.Scopes.Scope;
import main.Variables.Variable;

public class IfWhileLine extends Line {

    private String[] booleanExpressions;

    public IfWhileLine (String [] booleanExpressions){
        this.booleanExpressions = booleanExpressions;
    }

    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws NoBooleanExpressionInIfWhileCall
     */
    @Override
    public void LineCorrectness(Scope scope) throws NoBooleanExpressionInIfWhileCall{
        for (String expression:booleanExpressions){
            // if one of the given parameters isn't boolean Expressions
            if (!isBooleanExpressions(expression, scope)){
                throw new NoBooleanExpressionInIfWhileCall();
            }
        }
    }

    /* check if the given expression is boolean in current scope*/
    private boolean isBooleanExpressions(String expression, Scope scope){
        if (isNumber(expression)||isVariable(expression,scope)){
            return true;
        }
        return false;
    }

    /* checks if the string is variable in the scope. */
    private boolean isVariable (String expression, Scope scope){
        try{
            if (expression.equals("true|false")){
                return true;
            }
            Variable var = findVariable(expression, scope);
        }
        catch (IllegalLineException e){ // if isn't an exist variable
            return false;
        }
        return true;
    }

    /* checks if the string is number. */
    private boolean isNumber (String expression){
        try{
            Double d = Double.parseDouble(expression);
        }
        catch (NumberFormatException e){ // if can't be parse to number
            return false;
        }
        return true;
    }

    @Override
    public boolean startScope() {
        return true;
    }
}
