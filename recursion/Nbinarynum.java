import java.util.*;
public class Nbinarynum{
    private static void solve(int one,int zero,int n,String op)
    {
        if(n==0)
        {
            System.out.println("Generated number is : "+op);
            return;
        }
        if(one>zero)
        {
            solve(one,zero+1,n-1,op+'0');
        }
        solve(one+1,zero,n-1,op+'1');
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        String op = "";
        int ones=0;
        int zeroes=0;
        solve(ones,zeroes,n,op);
    }
}