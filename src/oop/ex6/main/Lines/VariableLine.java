package oop.ex6.main.Lines;


import oop.ex6.main.CodeException;
import oop.ex6.main.Lines.LineExceptions.IllegalLineException;
import oop.ex6.main.Lines.LineExceptions.ParameterHasNoValueException;
import oop.ex6.main.Lines.LineExceptions.VariableTypesAreNotCompatibleException;
import oop.ex6.main.Scopes.Scope;
import oop.ex6.main.Scopes.ScopeExceptions.ScopeException;
import oop.ex6.main.Variables.Variable;

import java.util.ArrayList;


/**
 * this class represents line that make some action with variables,for example definition of variable
 * or assignment value to some existed variable.
 */
public abstract class VariableLine extends Line{

    /**
     * The constructor of variable line receive the String that contains name of the variable and the value.
     * for example a = 5 ,that have to be separated by command 'split(=)',so after this split
     * name will be on the first place in formed array after splitting and value on the second,
     * consequently name will have index 0 and value index 1.
     */

    /*index that appropriate to the name of the variable. */
    private static final int VARIABLE_NAME_PLACE=0;

    /*index that appropriate to the value of the variable. */
    private static final int VARIABLE_VALUE_PLACE=1;

    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws CodeException exception that thrown in case that line is illegal.
     */
    @Override
    public abstract void LineCorrectness(Scope scope) throws CodeException;

    /**
     * this method separate the string (for example a=5) by char '='
     * @param variable string that contains name and probably value of the string.
     * @return array that contains on the first place name and if there is value,so it will be on the second place.
     */
    protected String[] getVariableComponents(String variable){
        return variable.split("\\s*=\\s*");
    }

    /**
     * this method extract name of the variable after splitting.
     * @param variableComponents splited string
     * @return name of the variable
     */
    protected String extractVariableName(String[] variableComponents){
        return variableComponents[VARIABLE_NAME_PLACE];
    }

    /**
     * this method extract value of the variable after splitting.
     * @param variableComponents splited string
     * @return value of the variable
     */
    protected String extractVariableValue(String[] variableComponents){
        return variableComponents[VARIABLE_VALUE_PLACE];
    }

    /**
     *
     * @param var
     * @param assignment
     * @return
     */
    protected boolean compatibilityOfTypes(Variable var, Variable assignment){
        String [] possibleTypes = var.possibleTypesForVariable();
        for (String type: possibleTypes){
            if (type.equals(assignment.getType())){
                return true;
            }
        }
        return false;
    }


    protected void checkAssignmentOfVariable (Variable var, Scope scope) throws CodeException{
        if (var.hasVariableValue()){ // if has a value that is variable search if such variable exists
            Variable variableForAssignment=findVariable(var.getValue(),scope);
            // find of there is such local or global variable
            boolean isCompatible=compatibilityOfTypes(var,variableForAssignment);
            if (!(isCompatible)){ // of the type isn't appropriate
                throw new VariableTypesAreNotCompatibleException();
            }
            if (variableForAssignment.hasValue()){ // if the assignment variable has no value
                var.checkValue(variableForAssignment.getValue());
            }
            else{ // if the variable has no value we can't define it as a value
                throw new ParameterHasNoValueException();
            }
        }
    }

}
