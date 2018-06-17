package main.Lines;

import main.Scopes.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public class AssignmentVariableLine extends VariableLine{
    ArrayList<AssignmentValueForVariable> assignmentsForVariables;
    static final int VARIABLE_NAME_PLACE=1;
    static final int VARIABLE_VALUE_PLACE=3;

    AssignmentVariableLine(String[] variables){
        this.assignmentsForVariables=new ArrayList<AssignmentValueForVariable>();
        for (String variable:variables){
            String[] variableComponents=getVariableComponents(variable);
            String name=extractVariableName(variableComponents);
            String value=extractVariableValue(variableComponents);
            assignmentsForVariables.add(new AssignmentValueForVariable(name,value));
        }

    }

    @Override
    public void LineCorrectness(Scope scope) {

    }
}
