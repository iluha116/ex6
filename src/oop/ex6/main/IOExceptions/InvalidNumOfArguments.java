package oop.ex6.main.IOExceptions;

/**
 * This is a sub-class of IOExceptions (exception that causes the program to end). It is
 * raised when the number of the input arguments is different then 2 (path of the source-directory,
 * and path of the commands-file).
 * @author Shani Cheskis
 * @author Ilia Bogov
 */


public class InvalidNumOfArguments extends IOExceptions {

    private static final String error = "Exactly 2 parameters are required apart from the code file:" +
            " path of the source-directory, and path of the commands-file";

    public InvalidNumOfArguments(){
        super(error);
    }
}
