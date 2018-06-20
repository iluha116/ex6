package main.Lines;

import main.CodeException;
import main.Lines.LineExceptions.DefiningExistedVariableException;
import main.Lines.LineExceptions.IllegalLineException;
import main.Scopes.Global;
import main.Scopes.InnerScope;
import main.Scopes.Scope;
import main.Scopes.ScopeExceptions.ScopeException;
import main.Variables.Variable;
import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesFactory;

import java.util.ArrayList;

public class DefiningVariableLine extends VariableLine{
    private ArrayList<Variable> nonDefaultVariables;
    private ArrayList<Variable> defaultVariables;
    private static final int DEFAULT_VARIABLE_COMPONENTS_NUMBER=1;
    private static final int NONDEFAULT_VARIABLE_COMPONENTS_NUMBER=2;

    DefiningVariableLine(String type,String[] variables,boolean ifFinal) throws VariableException{
        this.nonDefaultVariables=new ArrayList<Variable>();
        this.defaultVariables=new ArrayList<Variable>();

        for (String variable:variables){
            String[] variableComponents=getVariableComponents(variable);
            if (variableComponents.length==DEFAULT_VARIABLE_COMPONENTS_NUMBER){
                this.defaultVariables.add(VariablesFactory.
                        factoryDefault(type,extractVariableName(variableComponents),ifFinal,false));
            }
            else if(variableComponents.length==NONDEFAULT_VARIABLE_COMPONENTS_NUMBER){
                String name=extractVariableName(variableComponents);
                String value=extractVariableValue(variableComponents);
                this.nonDefaultVariables.add(VariablesFactory.factory(type,name,value,ifFinal));
            }

        }

    }

    public ArrayList<Variable> getDefaultVariables() {
        return defaultVariables;
    }

    public ArrayList<Variable> getNonDefaultVariables() {
        return nonDefaultVariables;
    }

    @Override
    public void LineCorrectness(Scope scope) throws CodeException{
        ArrayList<Variable> allVariables=unionVariables();
        for (Variable defaultVariable:allVariables){
            if (findVariableInInsertedArray(defaultVariable.getName(),scope.getLocalVariables())!=null){
                throw new DefiningExistedVariableException();
            }
        }
        if (!(scope instanceof Global)) {
            for (Variable defaultVariable:allVariables){
                if (findVariableInInsertedArray(defaultVariable.getName(),scope.getGarbageVariables())!=null||
                        findVariableInInsertedArray(defaultVariable.getName(),scope.getTimeVariables())!=null){
                    throw new DefiningExistedVariableException();
                }
            }
        }
    }
    private ArrayList<Variable> unionVariables(){
        ArrayList<Variable> allVariables= defaultVariables;
        allVariables.addAll(nonDefaultVariables);
        return allVariables;
    }
}
