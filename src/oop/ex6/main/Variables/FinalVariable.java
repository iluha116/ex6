package oop.ex6.main.Variables;

import oop.ex6.main.Variables.VariablesExceptions.ChangeFinalVariableException;
import oop.ex6.main.Variables.VariablesExceptions.VariableException;

/**
 * This class represents final decorator(give to Variable an ability to be final)
 */
public class FinalVariable extends Variable{
    Variable variable;

    public FinalVariable(Variable variable){
        this.variable=variable;
    }

    @Override
    public String getType() {
        return variable.getType();
    }

    @Override
    protected void checkValueAd(String value) throws VariableException {
        if (variable.hasVariableValue()){ // if a variable was defined can put the value
            variable.checkValueAd(value);
        }
       else{ // can't change final value
            throw new ChangeFinalVariableException();
        }

    }

    @Override
    public String getValue() {
        return variable.getValue();
    }

    @Override
    public String getName() {
        return variable.getName();
    }

    @Override
    public boolean hasValue() {
        return variable.hasValue();
    }

    @Override
    public boolean hasVariableValue() {
        return variable.hasVariableValue();
    }

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public String[] possibleTypesForVariable (){
        return variable.possibleTypesForVar;
    }
}
