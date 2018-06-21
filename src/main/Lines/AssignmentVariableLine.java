package main.Lines;

import main.CodeException;
import main.Lines.LineExceptions.CallToUnExistsParameter;
import main.Lines.LineExceptions.DefiningExistedVariableException;
import main.Lines.LineExceptions.IllegalLineException;
import main.Scopes.Scope;
import main.Variables.Variable;
import main.Variables.VariablesExceptions.VariableException;

import java.util.ArrayList;


/**
 * this class represents line that change or define value of some variable.
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
    AssignmentVariableLine(String variable){
            String[] variableComponents=getVariableComponents(variable);
            this.name=extractVariableName(variableComponents);
            this.value=extractVariableValue(variableComponents);
    }

    /**
     * this method is represents verifying that line is appropriate according to rules of s-Java.
     * @param scope -scope that contains required information for the verifying.
     * @throws CodeException-exception that thrown in case that line is illegal.
     */
    @Override
    public void LineCorrectness(Scope scope) throws CodeException{
        Variable variableForAssignment = null;
        for (int i=0;i<scope.getTimeVariables().size();i++){
            variableForAssignment = scope.getTimeVariables().get(i);
            if (variableForAssignment.getName().equals(name)){
                break;
            }
        }
        if (variableForAssignment==null){
            variableForAssignment=findVariable(name,scope);
            }
        else {

        }
        assignmentValueForVariable(variableForAssignment);
    }

    /**
     *
     * @return name of the variable
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return value of the variable.
     */
    public String getValue() {
        return value;
    }

    /**
     * this method make assignment of the variable.
     * @param variable variable value of which have to be changed.
     * @throws VariableException exception that thrown in case that assignment was not successful.
     */
    private void assignmentValueForVariable(Variable variable)throws VariableException{
        variable.checkValue(value);
    }
}
