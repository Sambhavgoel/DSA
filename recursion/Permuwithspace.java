import java.util.*;
public class Permuwithspace{
    private static void solve(String op,String ip)
    {
        if(ip.length()==0)
        {
            System.out.println(op);
            return;
        }
        solve((op+" "+ip.charAt(0)),ip.substring(1));
        solve(op+ip.charAt(0),ip.substring(1));
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String op = "";
        op=op+ip.charAt(0);
        solve(op,ip.substring(1));
    }
}