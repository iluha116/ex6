package main.Lines;

import main.Lines.LineExceptions.CallToUnExistsParameter;
import main.Lines.LineExceptions.DefiningExistedVariableException;
import main.Lines.LineExceptions.IllegalLineException;
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
    public void LineCorrectness(Scope scope) throws IllegalLineException{
        for (AssignmentValueForVariable assignment:assignmentsForVariables){
            boolean variableIsFounded=false;
            for (int i=0;i<scope.getTimeVariables().size();i++){
                Variable var = scope.getTimeVariables().get(i);
                if (var.getName().equals(assignment.getName())){
                    variableIsFounded=true;
                    break;
                }
            }if (!variableIsFounded){
                try{
                    findVariable(assignment.getName(),scope);
                    throw new DefiningExistedVariableException();
                }catch (CallToUnExistsParameter e){
                    continue;
                }
            }
        }
    }
}
