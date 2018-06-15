package main.Lines;

import main.Scopes.Scope;

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
