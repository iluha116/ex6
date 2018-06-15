package main;
import main.Lines.*;
import main.Variables.*;
import java.util.*;

abstract public class Scope {

    protected ArrayList<Method> methods;
    protected ArrayList<Line> lines;
    protected ArrayList<Variable> globalVariables;
    protected ArrayList<Variable> localVariables;

    public ArrayList<Line> getLines (){
        return lines;
    }

    public ArrayList<Method> getMethods (){
        return methods;
    }

    public ArrayList<Variable> getGlobalVariables (){
        return globalVariables;
    }

    public ArrayList<Variable> getLocalVariables (){
        return localVariables;
    }

    public abstract boolean isScopeCorrect ();

}
