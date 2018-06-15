package main.Lines;

import main.Scopes.Global;
import main.Scopes.Scope;

import java.util.ArrayList;

public class EndScope implements Line {

    public EndScope (String line){
    }

    public boolean isCorrect (Scope scope) throws IllegalLineException{
        ArrayList<Line> lines = scope.getLines();
        if ((!(scope instanceof Global))&&(lines.get(lines.size()-1)== this)){
            return true;
        }
        throw new IllegalLineException();
    }

    @Override
    public boolean endScope() {
        return true;
    }
}
