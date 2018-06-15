package main;

import java.text.MessageFormat;

public class CodeException extends Exception {

    private String baseMsg = "ERROR: {0} \n";
    String message;

    @Override
    public String getMessage() {
        return message;
    }
}
