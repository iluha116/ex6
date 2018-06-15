package main.Lines;


import main.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public abstract class VariableLine implements Line{
    private ArrayList<Variable> variables;
    public VariableLine(String[] varab){

    }

    @Override
    public abstract boolean isCorrect(Scope scope) ;
}
