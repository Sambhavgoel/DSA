import java.util.*;
public class kthsymbol{
    static int solve(int n , int k)
    {
        if(n==1 && k==1)
        {
            return 0;
        }
        int mid =(int) Math.pow(2,n-1)/2;
        if(k<=mid)
        {
            return solve(n-1,k);
        }else{
            return 1^solve(n-1,k-mid);
        }

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = solve(n,k);
        System.out.println(res);

    }
}