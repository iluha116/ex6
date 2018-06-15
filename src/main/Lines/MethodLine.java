package main.Lines;

import main.Global;
import main.Scope;
import main.Variables.Variable;

import java.util.ArrayList;

public class MethodLine implements Line {

    private Method method;

    public MethodLine (String name,String[] pairs){
        String[] methodParametersType=new String[pairs.length];
        String[] methodParametersName=new String[pairs.length];
        for (int i=0;i<pairs.length;i++){
            String[] pair=pairs[i].split(" ");
            methodParametersType[i]=pair[0];
            methodParametersName[i]=pair[1];
        }
        method=new Method(name,methodParametersName,methodParametersType);

    }

    public Method getFunction (){
        return method;
    }

    public boolean isCorrect (Scope scope) throws IllegalLineException{
        if (scope instanceof Global){
            return true;
        }
        throw new IllegalLineException();
    }

    @Override
    public boolean startScope() {
        return true;
    }
}
