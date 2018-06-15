import java.util.ArrayList;
import java.util.Iterator;
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
        while (t.hasNext()){
            String h= t.next();
            System.out.println(h);
        }

        String m = "wertyu     wtre retwretw     erwe";
        String [] f = m.split("\\s+");
        for (int i=0; i<f.length; i++){
            System.out.println(f[i]);
        }
    }



}
