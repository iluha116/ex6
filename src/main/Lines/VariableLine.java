package main.Lines;


import main.Scopes.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public abstract class VariableLine extends Line{

    private ArrayList<Variable> variables;

    public VariableLine(String[] variable){

    }

    @Override
    public abstract void LineCorrectness(Scope scope) ;
}
