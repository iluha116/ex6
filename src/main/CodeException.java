package main;

import java.text.MessageFormat;

/**
 * This class represents abstract class of exceptions that may be thrown in s-Java.
 */

public abstract class CodeException extends Exception {

    /*message that may be printed that contains information about thrown exception. */
    protected String message;

    /**
     *
     * @return String that contains information about thrown exception.
     */
    @Override
    public String getMessage() {
        return message;
    }
}
