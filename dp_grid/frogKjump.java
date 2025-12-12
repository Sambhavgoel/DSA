import java.util.*;
public class frogKjump {
    public static int cal(int n, int[]dp,int[]arr,int k)
    {
        for(int i=1;i<n;i++)
        {
            int steps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            {
                if(i-j>=0)
                {
                    int temp = dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    steps = Math.min(steps,temp);
                }
            }
            dp[i]=steps;
        }
        return dp[n-1];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int[]dp = new int[n];
        Arrays.fill(dp,0);
        int ans  =  cal(n,dp,arr,k);
        System.out.println(ans);
    }
}
