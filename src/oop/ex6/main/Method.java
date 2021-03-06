package oop.ex6.main;
import oop.ex6.main.Variables.Variable;
import oop.ex6.main.Variables.VariablesFactory;

/**
 * This class represents method, its name and parameter that are given to it.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */


import java.util.ArrayList;
import java.util.HashSet;

/**
 * this class represents container of data for creating method scope.
 */
public class Method {

    /*name of the method . */
    private String name;
    /*names of parameters. */
    private String [] names;
    /*types of parameters. */
    private String [] types;
    /*if parameters are final or not. */
    private boolean [] ifFinal;

    /**
     * Constructor
     * @param name of the method
     * @param parametersNames array of the parameter's names given to the method in order
     * @param parametersTypes array of the parameter's types given to the method in order
     * @param ifFinal boolean array if the parameter final in order of the parameters
     */
    public Method (String name, String [] parametersNames, String [] parametersTypes, boolean [] ifFinal){
        this.name = name;
        this.names = parametersNames;
        this.types = parametersTypes;
        this.ifFinal = ifFinal;

    }

    /**
     * @return name of the method
     */
    public String getName (){
        return name;
    }

    /**
     * @return array of the types of the parameters of the method.
     */
    public String[] getParametersTypes() {
        return types;
    }

    /**
     * Creates variables from the method line
     * @return ArrayList of variables
     */
    public ArrayList<Variable> createVariables (){
        ArrayList<Variable> vars = new ArrayList<>();
        for (int i=0; i < this.names.length; i++){
            Variable var = VariablesFactory.factoryDefault (types[i], names[i], ifFinal[i], true);
            vars.add(var);
        }
        return vars;
    }
}
