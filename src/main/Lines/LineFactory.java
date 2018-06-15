package main.Lines;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LineFactory {

    private static final String TYPES = "int|double|String|boolean|char";
    private static final String AND_OR = "&&|\\|{2}";
    private static final String SCOPES_TYPES = "if|while";
    private static final String METHOD_LINE =
            String.format("(void \\s+\\w+)(\\()(((final\\s+)? %1$s \\s+\\w+,)*" +
                    "((final\\s+)? %1$s \\s+\\w+)?)(\\))({)", TYPES);
    private static final String SCOPES_LINE =  String.format("\\s* (%1$s)(\\()", SCOPES_TYPES);




    public enum LogNameMatcher{
        FOO_LOG(".*Foo\\.log$"),
        BAR_LOG(".*bar\\.log$");

        private final Pattern pattern;

        private LogNameMatcher(final String regex) {
            this.pattern = Pattern.compile(regex);
        }

        public Pattern getPattern() { return this.pattern; }
    }


    public Line lineFactory(String args){
        Pattern method = Pattern.compile(METHOD_LINE);
        //Matcher line;

        switch (args){
            //line= method.matcher(args);
            case (""):
                break;
            default:
                break;
        }
        return null;
    }
}