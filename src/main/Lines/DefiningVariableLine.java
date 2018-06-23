package main.Lines;

import main.CodeException;
import main.Lines.LineExceptions.*;
import main.Scopes.*;
import main.Variables.Variable;
import main.Variables.VariablesExceptions.VariableException;
import main.Variables.VariablesFactory;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * this class represents line that define new variables.
 */
public class DefiningVariableLine extends VariableLine{
    /*array list of variables WITH value. */
    private ArrayList<Variable> nonDefaultVariables;
    /*array list of variables WITHOUT value. */
    private ArrayList<Variable> defaultVariables;
    /*number of components of some defined variable,for example:
    /*1 parameter in case that variable was defined without value. */
    private static final int DEFAULT_VARIABLE_COMPONENTS_NUMBER=1;
    /*2 parameters in case that variable was defined with value. */
    private static final int NONDEFAULT_VARIABLE_COMPONENTS_NUMBER=2;
    private HashSet<String> variablesNames;

    /**
     * this method represents constructor that creates new line with variables according to
     * parameters that was inserted.
     * @param type-type of inserted variables.
     * @param variables- strings that contains names of variables and probably value of them.
     * @param ifFinal- marker if variables are final or not.
     * @throws VariableException exception that thrown in case that
     * value of some variable is not appropriate for the type.
     */
    DefiningVariableLine(String type,String[] variables,boolean ifFinal) throws CodeException{
        this.nonDefaultVariables=new ArrayList<>();
        this.defaultVariables=new ArrayList<>();
        this.variablesNames = new HashSet<>();
        //for each variable add variable to default array(array with variables without value)
        //and to non-default array(array with variables that have some value. )
        for (String variable:variables){
            String[] variableComponents = getVariableComponents(variable);
            if (variableComponents.length == DEFAULT_VARIABLE_COMPONENTS_NUMBER){
                if (ifFinal){ // if final have to has a value in definition
                    throw new FinalHasNoValue();
                }
                // if only defining and checks that possible type
                String name=extractVariableName(variableComponents);
                checkNoRepeatingNames(name);
                this.defaultVariables.add(VariablesFactory.factoryDefault(type,name,ifFinal,false));
            }
            else if(variableComponents.length == NONDEFAULT_VARIABLE_COMPONENTS_NUMBER){
                String name=extractVariableName(variableComponents);
                checkNoRepeatingNames(name);
                String value=extractVariableValue(variableComponents).trim();
                this.nonDefaultVariables.add(VariablesFactory.factory(type,name,value,ifFinal));
            }
            else{ //another cases are not defined
                throw new NotAppropriateLineFormatException();
            }
        }
    }

    private void checkNoRepeatingNames(String name) throws DefiningExistedVariableException{
        if (variablesNames.contains(name)){
            throw new DefiningExistedVariableException();
        }
        variablesNames.add(name); // if is not already variable in the line
    }
    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws CodeException
     */
    @Override
    public void LineCorrectness(Scope scope) throws CodeException{
        //for all variables have to be checked that they is no variable with the
        // same name in some of arrays of scope.
        ArrayList<Variable> allVariables=unionVariables();
        // check if such variables are already exist in the local scope.
        for (Variable defaultVariable:allVariables){
            if (findVariableInInsertedArray(defaultVariable.getName(),scope.getLocalVariables())!=null){
                throw new DefiningExistedVariableException();
            }
        }
        // check if such variables are already exist in the garbage variables,
        // those variables that was defined in local scope without value and was not defined otherwise.
        // Time variables-variables that was defined in previous line without value.
        if (!(scope instanceof Global)) {
            for (Variable defaultVariable:allVariables){
                if (findVariableInInsertedArray(defaultVariable.getName(),scope.getGarbageVariables())!=null||
                        findVariableInInsertedArray(defaultVariable.getName(),scope.getTimeVariables())!=null){
                    throw new DefiningExistedVariableException();
                }
            }
        }
        // for variables with value verify if assignment is possible.
        for (Variable nonDefaultVariable:nonDefaultVariables){
            checkAssignmentOfVariable (nonDefaultVariable, scope);
        }
        scope.updateVariables(defaultVariables,nonDefaultVariables); // if all parameters legal,
        // update variables of the scope
    }

    /**
     * this method make union for to arrays arrays default and nondefault variables.
     * @return union of arrays.
     */
    private ArrayList<Variable> unionVariables(){
        ArrayList<Variable> allVariables= new ArrayList<>();
        allVariables.addAll(defaultVariables);
        allVariables.addAll(nonDefaultVariables);
        return allVariables;
    }
}
