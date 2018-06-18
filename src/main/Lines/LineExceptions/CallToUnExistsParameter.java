package main.Lines.LineExceptions;

public class CallToUnExistsParameter extends IllegalLineException{
    public CallToUnExistsParameter(){
        message="ERROR: the called variable is not exist ";
    }
}
