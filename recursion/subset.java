import java.util.*;
public class subset{
    static void solve(String ip,String op)
    {
        if(ip.length()==0)
        {
            System.out.println("substrings are : "+op);
            return;
        }
        // String op1 = op+ip.charAt(0);
        // String op2 = op;
        // solve(ip.substring(1),op1);
        // solve(ip.substring(1),op2);
        solve(ip.substring(1),op+ip.charAt(0));
        solve(ip.substring(1),op);
        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        
        String op = "";
        solve(inp,op);

    }
}