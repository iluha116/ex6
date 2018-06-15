package main.Lines;


import main.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public class VariableLine implements Line{
    private ArrayList<Variable> variables;
    public VariableLine(String[] varab){

    }

    @Override
    public boolean isCorrect(Scope scope) {
        return false;
    }
}
