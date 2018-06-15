package main.Lines;

import main.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public interface Line {

    public boolean isCorrect (Scope scope) throws IllegalLineException;

    default boolean startScope (){
        return false;
    }

    default boolean endScope (){
        return false;
    }

}
