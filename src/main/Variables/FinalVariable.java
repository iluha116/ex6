package main.Variables;

public class FinalVariable implements Variable {
    private Variable variable;
    FinalVariable(Variable variable){
        this.variable=variable;
    }

    @Override
    public void setValue(String value) throws ChangeFinalVariableException{
        throw new ChangeFinalVariableException();
    }

    @Override
    public String getName() {
        return variable.getName();
    }

    @Override
    public String getType() {
        return variable.getType();
    }

    @Override
    public String getValue() {
        return variable.getValue();
    }
}
