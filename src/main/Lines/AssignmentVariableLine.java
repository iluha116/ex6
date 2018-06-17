package main.Lines;

import main.Lines.LineExceptions.CallToUnExistsParameter;
import main.Lines.LineExceptions.DefiningExistedVariableException;
import main.Lines.LineExceptions.IllegalLineException;
import main.Scopes.Scope;
import main.Variables.Variable;

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
    public void LineCorrectness(Scope scope) throws IllegalLineException{
        boolean variableIsFounded=false;
        for (int i=0;i<scope.getTimeVariables().size();i++){
            Variable var = scope.getTimeVariables().get(i);
            if (var.getName().equals(name)){
                variableIsFounded=true;
                break;
            }
        }if (!variableIsFounded){
            try{
                findVariable(name,scope);
                throw new DefiningExistedVariableException();
            }catch (CallToUnExistsParameter e){
                return;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
