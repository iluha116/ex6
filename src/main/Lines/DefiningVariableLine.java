package main.Lines;

import main.Scopes.Scope;
import main.Variables.Variable;
import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesFactory;

import java.util.ArrayList;

public class DefiningVariableLine extends VariableLine{
    ArrayList<Variable> variables;
    static final int DEFAULT_VARIABLE_COMPONENTS_NUMBER=1;
    static final int NONDEFAULT_VARIABLE_COMPONENTS_NUMBER=3;

    DefiningVariableLine(String type,String[] variables,boolean ifFinal) throws VariableException{
        this.variables=new ArrayList<Variable>();
        for (String variable:variables){
            String[] variableComponents=getVariableComponents(variable);
            if (variableComponents.length==DEFAULT_VARIABLE_COMPONENTS_NUMBER){
                this.variables.add(VariablesFactory.
                        factoryDefault(type,extractVariableName(variableComponents),ifFinal,false));
            }else if(variableComponents.length==NONDEFAULT_VARIABLE_COMPONENTS_NUMBER){
                String name=extractVariableName(variableComponents);
                String value=extractVariableValue(variableComponents);
                this.variables.add(VariablesFactory.factory(type,name,value,ifFinal));
            }

        }

    }

    @Override
    public void LineCorrectness(Scope scope) {

    }
}
