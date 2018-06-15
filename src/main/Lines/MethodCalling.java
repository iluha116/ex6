package main.Lines;

import main.Global;
import main.Scope;
import main.Variables.Variable;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class MethodCalling implements Line{
    private String[] parameters;
    private String name;

    /**
     *
     * @param name
     * @param parameters
     */
    public MethodCalling(String name,String[] parameters){
        this.parameters=parameters;
        this.name=name;
    }

    @Override
    public boolean isCorrect(Scope scope) throws IllegalLineException {
        if (!(scope instanceof Global)){
            for (Method method:scope.getMethods()){
                String[] methodTypes = method.getParametersTypes();

                if ((method.getName().equals(name)) && (methodTypes.length == parameters.length)){
                    for (int i=0; i<methodTypes.length; i++){
                    }

                }
            }
        }
        throw new IllegalLineException();
    }

    /* */
    private String[] checkParametersTypes (ArrayList <Variable> values) throws IllegalLineException{
        String [] types = new String[parameters.length];
        for (int i=0; i<parameters.length; i++){
            int index = findVariable(parameters[i], values);
        }
        return types;
    }

    private int findVariable (String val, ArrayList<Variable> values){
        for (int i=0; i<values.size(); i++){
            Variable var = values.get(i);
            if (var.getName().equals(val)){
                return i;
            }
        }
        return -1;
    }


}
