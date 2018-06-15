package main.Lines;

import main.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public class CallMethodLine implements Line{

    private String methodCall;

    public CallMethodLine (String line){

    }

    public boolean isCorrect (Scope scope){
        return true;
    }
}
