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
        ArrayList<String> a = new ArrayList<String>();
        a.add("waertdy");
        s(a);
        Iterator<String> t= a.iterator();

        String m = "wertyu     wtre redrew     erwe";
        String [] f = m.split("\\s+");


        final String TYPES = "(int|double|String|boolean|char)";
        final String AND_OR = "&&|\\|{2}";
        final String SCOPES_TYPES = "if|while";
        final String METHOD_LINE =("(\\s*void\\s+\\w+)(\\()(((final\\s+)?(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+),)*" +
                "((final\\s+)?(int|double|String|boolean|char)\\s+([A-Za-z]+\\w*|_+\\w+)))|(\\s*)\\s*\\{");
        final String SCOPES_LINE =  ("\\s*(if|while)\\s*(\\()((\\w+\\s*(&&|\\|{2})\\s*)" +
                "*(\\s*\\w+\\s*)?)(\\)\\s*\\{)");
        Pattern method = Pattern.compile(METHOD_LINE);
        Matcher matcher = method.matcher("if (void foo (int a)){");
        final String tr=String.format("void\\s+\\w+\\ %1$s",TYPES);
        Pattern p=Pattern.compile(tr);
        Matcher mm=p.matcher("void soo boolean,");
        System.out.println(mm.matches());

        System.out.println(matcher.matches());
        System.out.println(matcher.group(3));
        final String DEFINING_VARIABLE_LINE=("\\s*(final\\s+)?(\\w+)\\s+" +
                "((\\w+(\\s*=\\s*(('[^']*')|(\"[^\"]*\")|([\\w\\d]+))\\s*)?\\s*,\\s*)*" +
                "(\\w+(\\s*=\\s*(('[^']*')|(\"[^\"]*\")|([\\w\\d]+))\\s*)?)\\s*)(;)");

        final String ASSIGNMENT_VARIABLE_LINE=".";
        Pattern pat=Pattern.compile(DEFINING_VARIABLE_LINE);
        Matcher mat=pat.matcher("final int a=\"@\";");
        System.out.println(mat.matches());
//        System.out.println(mat.group(1));


    }





}
