package main.Lines;
import main.CodeException;
import main.Lines.LineExceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LineFactory {

    private static final String TYPES = "(int|double|String|boolean|char)";
    private static final String AND_OR = "(&&|\\|{2})";
    private static final String SCOPES_TYPES = "(if|while)";
    private static final String METHOD_LINE =
            String.format("(void\\s+\\w+)(\\()(((final\\s+)?%1$s\\s+\\w+,)*" +
                    "((final\\s+)?%1$s\\s+\\w+)?)(\\)\\s*\\{)", TYPES);
    private static final String SCOPES_LINE = String.format("\\s*%1$s\\s*(\\()((\\w+\\s*%2$s\\s*)" +
            "*(\\s*\\w+\\s*)?)(\\)\\s*\\{)", SCOPES_TYPES, AND_OR);
    private static final String DEFINITION_VARIABLE_LINE=String.format
            ("\\s*(final\\s+)?%1$s\\s+" +
                    "((\\w+(\\s+=\\s+((('|\\|\")\\s*)[\\.^\"]*(\\s*('|\\|\"))|\\|([\\d\\w]+)|\\|[\\.]))?\\s+,\\s+)*" +
                    "(\\w+(\\s+=\\s+((('|\\|\")\\s*)\\S*(\\s*('|\\|\"))||([\\d\\w]+)))?\\s*))(;)",TYPES);

    private static final String ASSIGNMENT_VARIABLE_LINE=
            "\\s*(\\w+(\\s+=\\s+((('|\\|\")\\s*)\\S*(\\s*('|\\|\"))||([\\d\\w]+)))\\s*)(;)";
    private static final String COMMENTS_LINE= "(\\s*(\\\\)(\\w*))|\\s*";



    private static final String[] REGEX = {SCOPES_LINE,METHOD_LINE,SCOPES_LINE,DEFINITION_VARIABLE_LINE,COMMENTS_LINE};

    /**
     * Factory
     * @param line one line from the code
     * @return Line object
     */
    public static Line lineFactory(String line) throws CodeException{
        Line lineForReturning = null;
        Pattern appropriatePattern = null;
        String appropriateRegex = null;
        Matcher matcher = null;
        for (String regex:REGEX){ // searching for appropriate pattern
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(line);
            if (matcher.matches()){
                appropriatePattern=pattern;
                appropriateRegex = regex;
                break;
            }
        }
        //Matcher line;
        if (appropriatePattern!=null){
            switch (appropriateRegex){
                case "\\s*(final\\s+)?(int|double|String|boolean|char)\\s+" +
                        "((\\w+(\\s+=\\s+((('|\\|\")\\s*)[\\.^\"]*(\\s*('|\\|\"))|\\|([\\d\\w]+)|\\|[\\.]))" +
                        "?\\s+,\\s+)*" +
                        "(\\w+(\\s+=\\s+((('|\\|\")\\s*)\\S*(\\s*('|\\|\"))||([\\d\\w]+)))?\\s*))(;)":
                    boolean ifFinal=!(matcher.group(1)==null);
                    String[] variables=matcher.group(3).split("\\s*,\\s*");
                    lineForReturning=new DefiningVariableLine(matcher.group(2),variables,ifFinal);
                    break;
                case ASSIGNMENT_VARIABLE_LINE:
                    lineForReturning=new AssignmentVariableLine(matcher.group(1));
                    break;
                default:
                    break;
            }
        }
        else {
            throw new IllegalLineException();
        }
        return lineForReturning;
    }
}
