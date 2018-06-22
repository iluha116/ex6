import main.Sjavac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {

    public static void s (ArrayList<String> b){
        b.add("sdfgh");
        b.add("t");
    }


    public static void main(String[] args) {


            //    ("(\\s*void\\s+\\w+)(\\()(((final\\s+)?\\s+([A-Za-z]+\\w*|_+\\w+),)*" +
             //           "((final\\s+)?(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+)))|(\\s*)\\s*\\{)");

        final String METHOD_LINE ="\\s*void\\s++(.\\w*)\\s*\\((\\s*|\\s*" +
                "(((final\\s+)?(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+),\\s*)*(final\\s+)?" +
                "(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+)))\\s*\\)\\s*\\{\\s*";


        final String SCOPES_LINE = "\\s*(if|while)\\s*(\\()((\\s*[\\w.-]+\\s*(&&|\\|{2})\\s*)" +
                "*(\\s*[\\w.-]+\\s*)?)(\\)\\s*\\{)";
        final String RETURN_LINE="\\s*return\\s*;\\s*";


        Pattern method = Pattern.compile(SCOPES_LINE);
       Matcher matcher = method.matcher("  if (  2   ||  -3  ){");

        //System.out.println(matcher.matches());

        String [] a = {"C:\\Users\\Shani\\IdeaProjects\\ex6\\ex6\\src\\tester_files\\Tests\\BaraksTests\\methods\\08.sjava"};
        Sjavac.main(a);

    }





}
