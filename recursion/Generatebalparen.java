import java.util.*;
public class Generatebalparen{
    private static void solve(int open,int close,String op)
    {
        if(open==0 && close==0)
        {
            System.out.println("Generated output is : "+op);
            return ;
        }
        if(open!=0)
        {
            solve(open-1,close,op+'(');
        }
        if(close>open)
        {
            solve(open,close-1,op+')');
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int open = n;
        int close = n;
        String op = "";
        solve(open,close,op);
    }
}