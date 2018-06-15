package main.Lines;

import main.Scopes.Global;
import main.Scopes.Scope;

import java.util.ArrayList;

public class ReturnLine implements Line {

    public ReturnLine(){
    }

    public boolean isCorrect (Scope scope)throws IllegalLineException{
        ArrayList<Line> lines = scope.getLines();
        if ((!(scope instanceof Global))&&(lines.get(lines.size()-2)== this)){
            return true;
        }
        throw new IllegalLineException();
    }
}
