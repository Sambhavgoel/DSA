import java.util.*;
public class Permuchangecase{
    private static void solve(String ip,String op)
    {
        if(ip.length()==0)
        {
            System.out.println("substrings are : "+op);
            return;
        }
        char ch = ip.charAt(0);
        solve(ip.substring(1),op+ip.charAt(0));
        solve(ip.substring(1),op+ Character.toUpperCase(ch));
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);
        String ip = sc.nextLine();
        String op = "";
        solve(ip,op);
    }
}