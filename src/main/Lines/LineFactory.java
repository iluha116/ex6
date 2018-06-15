package main.Lines;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LineFactory {

    private static final String types = "int";
    private static final String methodRegex = "void//s+[a-zA-Z0-9_]//s*[a-zA-Z, 0-9]*";


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
        Pattern method = Pattern.compile(methodRegex);
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
