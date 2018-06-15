package main.Lines;

import main.Scope;
import main.Scopes.IfWhile;

public class IfWhileLine implements Line {

    public IfWhileLine (){

    }

    @Override
    public boolean isCorrect(Scope scope) {
        return false;
    }

    @Override
    public boolean startScope() {
        return true;
    }
}
