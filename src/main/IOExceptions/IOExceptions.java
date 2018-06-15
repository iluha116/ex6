package main.IOExceptions;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * This is a class of IOExceptions that cause the program to end.
 * @author Shani Cheskis
 * @author Ilia Bogov
 */

public class IOExceptions extends IOException {

    private String baseMsg = "ERROR: {0} \n";
    String message;

    public IOExceptions (String error){
        message = MessageFormat.format(baseMsg, error);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
