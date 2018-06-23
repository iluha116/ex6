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

        final String METHOD_LINE ="\\s*void\\s++([A-Za-z]\\w*)\\s*\\((\\s*|\\s*" +
                "(((final\\s+)?(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+),\\s*)*(final\\s+)?" +
                "(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+)))\\s*\\)\\s*\\{\\s*";



        String METHOD_CALL ="\\s*([A-Za-z]\\w*)\\s*(\\(\\s*)(\\s*|(\\s*(([A-Za-z]+\\w*|_+\\w+|\\w+|('[^']*')|(\"[^\"]*\"))\\s*,\\s*)*" +
                "([A-Za-z]+\\w*|_+\\w+|\\w+|('[^']*')|(\"[^\"]*\"))))\\s*\\)\\s*;\\s*";
        final String RETURN_LINE ="[A-Za-z]+\\w*|_+\\w+";

        Pattern method = Pattern.compile(METHOD_CALL);
       Matcher matcher = method.matcher("boo(1,2,\"hello\");");

       System.out.println(matcher.matches());

        String [] a = {"C:\\Users\\Shani\\IdeaProjects\\ex6\\ex6\\src\\tester_files\\Tests\\SchoolTests\\test501.sjava"};
        Sjavac.main(a);


    }

}
