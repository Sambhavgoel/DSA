import java.util.*;
public class Permulettercase{
    private static void solve(String ip , String op)
    {
        if(ip.length()==0)
        {
            System.out.println("Generated substrings are :  "+op);
            return ;
        }
        if(Character.isLetter(ip.charAt(0)))
        {
            solve(ip.substring(1),op+Character.toUpperCase(ip.charAt(0)));
            solve(ip.substring(1),op+Character.toLowerCase(ip.charAt(0)));
        }
        else{
            solve(ip.substring(1),op+ip.charAt(0));
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String op = "";
        solve(ip,op);
    }
}