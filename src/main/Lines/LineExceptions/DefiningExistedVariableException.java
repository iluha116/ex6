package main.Lines.LineExceptions;

public class DefiningExistedVariableException extends IllegalLineException{
    public DefiningExistedVariableException(){
        message="attempt to define a variable that already exist in the scope";
    }
}
