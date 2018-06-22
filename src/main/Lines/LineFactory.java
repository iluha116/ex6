package main.Lines;
import main.CodeException;
import main.Lines.LineExceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LineFactory {

    private static final String TYPES = "(int|double|String|boolean|char)";
    private static final String AND_OR = "(&&|\\|{2})";
    private static final String SCOPES_TYPES = "(if|while)";
    private static final String METHOD_LINE ="\\s*void\\s++(.\\w*)\\s*\\((\\s*|\\s*" +
            "(((final\\s+)?(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+),\\s*)*(final\\s+)?" +
            "(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+)))\\s*\\)\\s*\\{\\s*";
    private static final String SCOPES_LINE = ("\\s*(if|while)\\s*(\\()((\\w+\\s*(&&|\\|{2})\\s*)" +
            "*(\\s*\\w+\\s*)?)(\\)\\s*\\{)");
    private static final String DEFINITION_VARIABLE_LINE="\\s*(final\\s+)?(\\w+)\\s+" +
            "((\\w+(\\s*=\\s*(('[^']*')|(\"[^\"]*\")|([\\w\\d]+))\\s*)?\\s*,\\s*)*" +
            "(\\w+(\\s*=\\s*(('[^']*')|(\"[^\"]*\")|([\\w\\d]+))\\s*)?)\\s*)(;)";

    private static final String ASSIGNMENT_VARIABLE_LINE=
            "\\s*(\\w+(\\s*=\\s*(('[^']*)|(\"[^\"]*\")|([\\w\\d]+))\\s*))\\s*;";
    private static final String COMMENTS_LINE= "(\\s*(\\\\{2})(\\w*))|\\s*";
    private static final String END_SCOPE="\\s*}\\s*";
    private static final String RETURN_LINE="\\s*return\\s*;\\s*";



    private static final String[] REGEX =
            {SCOPES_LINE,METHOD_LINE,DEFINITION_VARIABLE_LINE,RETURN_LINE,
                    COMMENTS_LINE,ASSIGNMENT_VARIABLE_LINE,END_SCOPE,};

    /**
     * Factory
     * @param line one line from the code
     * @return Line object
     */
    public static Line lineFactory(String line) throws CodeException{
        Line lineForReturning = null;
        String appropriateRegex = null;
        Matcher matcher = null;
        for (String regex:REGEX){ // searching for appropriate pattern
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(line);
            if (matcher.matches()){
                appropriateRegex = regex;
                break;
            }
        }
        if (appropriateRegex!=null){
            switch (appropriateRegex){
                case DEFINITION_VARIABLE_LINE:
                    boolean ifFinal=!(matcher.group(1)==null);
                    String[] variables =matcher.group(3).split("\\s*,\\s*");
                    lineForReturning=new DefiningVariableLine(matcher.group(2),variables,ifFinal);
                    break;
                case ASSIGNMENT_VARIABLE_LINE:
                    lineForReturning=new AssignmentVariableLine(matcher.group(1));
                    break;
                case COMMENTS_LINE:
                    lineForReturning=new CommentsLine();
//                    System.out.println("comment");
                    break;
                case SCOPES_LINE:
                    String[] expression=matcher.group(3).split(AND_OR);
                    lineForReturning=new IfWhileLine(expression);
                    //System.out.println("ifWhile");
                    break;
                case METHOD_LINE:
                    String[] variable;
                    if (matcher.group(2).equals("")){
                        variable = new String[0];
                    }
                    else{
                        variable = matcher.group(2).split("\\s*,\\s*");
                    }
                    lineForReturning=new MethodLine(matcher.group(1), variable);

                    break;
                case END_SCOPE:
                    lineForReturning=new EndScope();
//                    System.out.println("end");
                    break;
                case RETURN_LINE:
//                    System.out.println("return");
                    lineForReturning=new ReturnLine();
                    break;
                default:
                    throw new NotAppropriateLineFormatException();
            }
        }
        else {
            throw new NotAppropriateLineFormatException();
        }
        return lineForReturning;
    }
}
