package main.Lines;


import main.Scopes.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public abstract class VariableLine extends Line{
    static final int VARIABLE_NAME_PLACE=1;
    static final int VARIABLE_VALUE_PLACE=3;

    @Override
    public abstract void LineCorrectness(Scope scope) ;

    protected String[] getVariableComponents(String variable){
        return variable.split("\\s+");
    }
    protected String extractVariableName(String[] variableComponents){
        return variableComponents[VARIABLE_NAME_PLACE];
    }

    protected String extractVariableValue(String[] variableComponents){
        return variableComponents[VARIABLE_VALUE_PLACE];
    }

}
