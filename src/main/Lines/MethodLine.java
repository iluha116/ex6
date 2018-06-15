package main.Lines;
import main.Scopes.Global;
import main.Scopes.Scope;

import java.util.ArrayList;

public class MethodLine implements Line {

    private Method method;

    public MethodLine (String name, String[] variables){
        String[] types = new String[variables.length];
        String[] names = new String[variables.length];
        boolean [] ifFinal = new boolean[variables.length];
        for (int i=0;i<variables.length;i++){
            String[] pair = variables[i].split(" "); // parameters of the cur variable
            if (pair.length == 2){ // if has not final
                types[i] = pair[0];
                names[i] = pair[1];
                ifFinal[i]= false;
            }
            else{ // if has final
                types[i] = pair[1];
                names[i] = pair[2];
                ifFinal[i]= true;
            }
        }
        this.method = new Method(name,names,types,ifFinal);
    }

    public boolean isCorrect (Scope scope) throws IllegalLineException{
        if (scope instanceof Global){
            return true;
        }
        throw new IllegalLineException();
    }

    /**/
    private void updateScopeParameters (Scope scope){
        ArrayList<Method> methods = scope.getMethods();
        methods.add(method);
    }

    @Override
    public boolean startScope() {
        return true;
    }
}
