package main.Variables.VariablesExceptions;

public class NoTypeOfVariable extends VariableException {
    public NoTypeOfVariable(){
        message="Variable cannot be defined without type.";
    }
}
