package main.Variables;

import main.Variables.VariablesExceptions.ChangeFinalVariableException;
import main.Variables.VariablesExceptions.FinalHasNoValue;
import main.Variables.VariablesExceptions.VariableException;

public class FinalVariable extends Variable{
    Variable variable;

    public FinalVariable(Variable variable) throws FinalHasNoValue{
        if (variable.hasValue()){
            this.variable=variable;
        }
        else{
            throw new FinalHasNoValue();
        }
    }
    public FinalVariable(Variable variable, boolean ifDefault){
        this.variable=variable;
    }

    @Override
    public String getType() {
        return variable.getType();
    }

    @Override
    protected void checkValueAd(String value) throws VariableException {
        throw new ChangeFinalVariableException();
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

}
