import java.util.*;
public class Unqsubset{
    private static void solve(String ip,String op,HashSet<String> hs)
    {
        if(ip.length()==0)
        {
            // System.out.println("substrings are : "+op);
            hs.add(op);
            return;
        }
        solve(ip.substring(1),op+ip.charAt(0),hs);
        solve(ip.substring(1),op,hs);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        HashSet<String> hs = new HashSet<>();
        String ip = sc.nextLine();
        String op = "";
        solve(ip,op,hs);
        System.out.println(hs);

    }
}