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

        String m = "wertyu     wtre retwretw     erwe";
        String [] f = m.split("\\s+");


        final String TYPES = "(int|double|String|boolean|char)";
        final String AND_OR = "&&|\\|{2}";
        final String SCOPES_TYPES = "if|while";
        final String METHOD_LINE =
                String.format("(void\\s+\\w+)(\\()(((final\\s+)?%1$s\\s+\\w+,)*((final\\s+)?%1$s\\s+\\w+)?)(\\)\\s*\\{)", TYPES);
        final String SCOPES_LINE =  String.format("\\s* (%1$s)(\\()", SCOPES_TYPES);
        Pattern method = Pattern.compile(METHOD_LINE);
        Matcher matcher = method.matcher("void soo  (final     char   b) {");
        final String tr=String.format("void\\s+\\w+\\ %1$s",TYPES);
        Pattern p=Pattern.compile(tr);
        Matcher mm=p.matcher("void soo boolean");
        System.out.println(mm.matches());

        System.out.println(matcher.matches());
    }





}
