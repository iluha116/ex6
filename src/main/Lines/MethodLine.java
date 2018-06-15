package main.Lines;

import main.Global;
import main.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public class MethodLine implements Line {

    Method method;

    public MethodLine (String line){

    }

    public Method getFunction (){
        return method;
    }

    public boolean isCorrect (Scope scope) throws IllegalLineException{
        if (scope instanceof Global){
            return true;
        }
        throw new IllegalLineException();
    }

    @Override
    public boolean startScope() {
        return true;
    }
}
