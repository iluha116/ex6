package main.Lines.LineExceptions;

public class SearchForUnExistsParameter extends IllegalLineException{
    public SearchForUnExistsParameter(){
        message="attempt to find a variable that is not exists in the scope.";
    }
}
