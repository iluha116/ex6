package oop.ex6.main.Lines.LineExceptions;

/**
 * This class represents exception that thrown in case when there
 * was attempt to find variable that is not exists in the scope.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class SearchForUnExistsParameter extends IllegalLineException{

    /**
     * this method represents constructor where exception receives the message that contains the
     * description of the error.
     */
    public SearchForUnExistsParameter(){
        message="attempt to find a variable that is not exists in the scope.";
    }
}
