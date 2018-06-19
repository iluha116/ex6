package main.Lines;

import main.CodeException;
import main.Lines.LineExceptions.CallToUnExistsParameter;
import main.Lines.LineExceptions.DefiningExistedVariableException;
import main.Lines.LineExceptions.IllegalLineException;
import main.Scopes.Scope;
import main.Variables.Variable;
import main.Variables.VariablesExceptions.VariableException;

import java.util.ArrayList;

public class AssignmentVariableLine extends VariableLine{
    static final int VARIABLE_NAME_PLACE=1;
    static final int VARIABLE_VALUE_PLACE=3;
    private String name;
    private String value;

    AssignmentVariableLine(String variable){
            String[] variableComponents=getVariableComponents(variable);
            this.name=extractVariableName(variableComponents);
            this.value=extractVariableValue(variableComponents);

    }

    @Override
    public void LineCorrectness(Scope scope) throws CodeException{
        Variable variableForAssignment=null;
        for (int i=0;i<scope.getTimeVariables().size();i++){
            variableForAssignment = scope.getTimeVariables().get(i);
            if (variableForAssignment.getName().equals(name)){
                break; // return maybe, break should get out of the if only??
            }
        }
        if (variableForAssignment==null){
            variableForAssignment=findVariable(name,scope);
            }
        assignmentValueForVariable(variableForAssignment);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void assignmentValueForVariable(Variable variable)throws VariableException{
        variable.setValue(value);
    }
}
