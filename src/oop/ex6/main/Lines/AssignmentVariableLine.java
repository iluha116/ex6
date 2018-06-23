package oop.ex6.main.Lines;

import oop.ex6.main.CodeException;
import oop.ex6.main.Scopes.Scope;
import oop.ex6.main.Variables.Variable;

/**
 * this class represents line that change or define value of some variable.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class AssignmentVariableLine extends VariableLine{
    /*name of the variable value of which have to be changed. */
    private String name;
    /*value for assignment. */
    private String value;

    /**
     * this method creates a line that contains name of the variable for assignment and value that
     * have to be assigned.
     * @param variable-string that contains name and value of the Variable.
     */
    public AssignmentVariableLine(String variable){
        String[] variableComponents=getVariableComponents(variable);
        this.name = extractVariableName(variableComponents);
        this.value = extractVariableValue(variableComponents).trim();
    }

    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws CodeException-exception that thrown in case that line is illegal.
     */
    @Override
    public void LineCorrectness(Scope scope) throws CodeException{
        Variable variableForAssignment = null; // pointer for variable which will receive value
        //find variable to which we want to assign value.
        for (int i=0;i<scope.getTimeVariables().size();i++){
            //try to find in timeVariables (variables that was defined in previous line without value).
            if (scope.getTimeVariables().get(i).getName().equals(name)){
                variableForAssignment = scope.getTimeVariables().get(i);
                scope.removeFromTimeVariables(variableForAssignment);
                break;
            }
        }
        //If it wasn't founded in timeVariables try to find it in local and global variables.
        if (variableForAssignment == null){
            variableForAssignment=findVariable(name,scope);
            //if it wasn't found yet, findVariable throws exception
        }
        variableForAssignment.checkValue(value); // assignment of the value
        checkAssignmentOfVariable (variableForAssignment, scope);
    }

    /**
     * @return name of the variable
     */
    public String getName() {
        return name;
    }

    /**
     * @return value of the variable.
     */
    public String getValue() {
        return value;
    }

}
