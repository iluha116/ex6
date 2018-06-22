package main.Variables.VariablesExceptions;

public class FinalHasNoValue extends VariableException{
    public FinalHasNoValue(){
        message="attempt to define final variable without value.";
    }
}
