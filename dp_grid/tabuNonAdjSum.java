import java.util.*;
public class tabuNonAdjSum {
    public static int cal(int n , int[]arr, int[]dp)
    {
        dp[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            int left = arr[i];
            if(i>1)
            {
                left+=dp[i-2];
            }
            int right = dp[i-1];

            dp[i] = Math.max(left,right);
        }
        return dp[n-1];
    }
    public static int optimize(int n , int []arr)
    {
        int prev=arr[0];
        int prev2=0;

        for(int i=1;i<n;i++)
        {
            int left = arr[i];
            if(i>1)
            {
                left+=prev2;
            }
            int right = prev;
            int cur = Math.max(left,right);

            prev2=prev;
            prev=cur;
        }
        return prev;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]= sc.nextInt();
        }
        int[]dp = new int[n];
        Arrays.fill(dp,0);
        int ans = cal(n,arr,dp);
        System.out.println("tabu : "+ans);
        int res = optimize(n,arr);
        System.out.println("optimize : "+res);
    }
}
