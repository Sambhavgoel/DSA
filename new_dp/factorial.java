import java.util.*;
class factorial{
    public static int recursion(int n)
    {
        if(n<=1)
        {
            return n;
        }
        return recursion(n-1)+recursion(n-2);
    }
    public static int memo(int n,int[]dp)
    {
        if(n<=1)
        {
            return n;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        return dp[n] = memo(n-1,dp)+memo(n-2,dp);
    }
    public static int tabu(int n, int[]dp)
    {
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int space(int n)
    {
        int prev=1;
        int prev2=0;
        for(int i=2;i<=n;i++)
        {
            int cur = prev+prev2;
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

// .............................................................
        //recursion
        // int ans = recursion(n);
        // System.out.println(ans);
// ..................................................................
        //memoization - (top-down)
        // int[]dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // int ans1 = memo(n,dp);
        // System.out.println(ans1);
// .....................................................................
        //tabulation - (bottom-up)
        // int[]dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // dp[0]=0;
        // dp[1]=1;
        // int ans3 = tabu(n,dp);
        // System.out.println(ans3);
// ..................................................................................
        //space optimizaton
        // int ans4 = space(n);
        // System.out.println(ans4);

    }
}