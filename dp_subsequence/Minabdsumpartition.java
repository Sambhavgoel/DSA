import java.util.*;
class Minabdsumpartition {
    public static void cal(int[]arr,int target, boolean[][]dp){

        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }
        if(arr[0]<=target)
        {
            dp[0][target]=true;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                boolean nottake = dp[i-1][j];
                boolean take = false;
                if(arr[i]<=j)
                {
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j]= nottake || take;

            }
        }

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        int totalsum=0;
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            totalsum+=arr[i];
        }
        int target=totalsum;
        boolean[][] dp =new boolean[n][target+1];

        cal(arr,target,dp);

        int ans = Integer.MAX_VALUE;
        for(int i=target/2;i>=0;i--)
        {
            if(dp[n-1][i])
            {
                ans = Math.abs(i-(target-i));
                break;
            }
        }
        System.out.println(ans);


    }
}
