import java.util.ArrayList;
import java.util.List;


public class AllLess {

    public static List<String> allLess(String[] s, int x){

        List<String> results = new ArrayList<>();


        for (int i = 0; i < s.length; i++) {

            if(s[i] == null|| s[i].equals("")){
                continue;
            }else if(s[i].length() < x){
                results.add(s[i]);

            }

        }
        return results;
    }

    public static void main(String[] args){

        AllLess main = new AllLess();

        String[] s = {"zero", " size", "nutella", "jojo", "luna", "isse", "astor", "as", "entretien", null , "cal"};
        int x = 6;

        List results = allLess(s,x);

        String r = results.toString();

        System.out.println(r);

    }

}
