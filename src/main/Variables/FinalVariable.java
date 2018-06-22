package main.Variables;

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

    @Override
    public String[] possibleTypesForVariable() {
        return variable.possibleTypesForVariable();
    }

    @Override
    public String getType() {
        return variable.getType();
    }

    @Override
    public void checkValue(String value) throws VariableException {
        variable.checkValue(value);
    }

    @Override
    protected void checkValueAd(String value) throws VariableException {
        variable.checkValueAd(value);
    }

}
