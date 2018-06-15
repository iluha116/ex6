package main.Scopes;

import main.Lines.*;
import main.Variables.Variable;

import java.util.ArrayList;

public interface Scope {

    public boolean checkScope (ArrayList<Variable> globals, ArrayList<Method> methods);

}
