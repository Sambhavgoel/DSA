import java.util.*;
public class memoClimbStairs {
    public static int cal(int n,int[]dp)
    {
        if(n==0||n==1) return dp[n];
        if(dp[n]!=-1) return dp[n];

        int left = cal(n-1,dp);
        int right = cal(n-2,dp);

        dp[n]=left+right;
        return dp[n];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []dp= new int[n+1];
        Arrays.fill(dp,-1);
        dp[1]=1;
        dp[0]=1;



        int ans = cal(n,dp);
        System.out.println("ans"+ans);

    }
}
