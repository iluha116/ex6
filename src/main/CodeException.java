package main;

import java.text.MessageFormat;

public abstract class CodeException extends Exception {

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }
}
