package main.Lines;

import main.Scopes.Scope;

public interface Line {

    public boolean isCorrect (Scope scope) throws IllegalLineException;

    default boolean startScope (){
        return false;
    }

    default boolean endScope (){
        return false;
    }

}
