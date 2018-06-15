package main.Scopes;

import main.Lines.*;
import main.Variables.Variable;

import java.util.ArrayList;

public class IfWhile implements Scope {

    public IfWhile (ArrayList<Variable> globals, ArrayList<Method> methods, ArrayList<Line> lines){

    }

    public boolean checkScope (ArrayList<Variable> globals, ArrayList<Method> methods){
        return true;
    }
}
