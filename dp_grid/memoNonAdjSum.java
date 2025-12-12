import java.util.*;
public class memoNonAdjSum {
    public static int cal(int n , int[]arr, int[] dp)
    {
        if(n==0) return arr[0];
        if(n<0) return 0;

        if(dp[n]!=-1) return dp[n];

        int left = cal(n-2,arr,dp)+ arr[n];
        int right = cal(n-1,arr,dp);

        dp[n]= Math.max(left,right);
        return dp[n];

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = cal(n-1,arr,dp);
        System.out.println(ans);
    }
}
