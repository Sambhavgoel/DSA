import java.util.*;
class Mincoins {
    public static int recur(int[]arr, int target, int idx)
    {
        if(idx==0)
        {
            if(target%arr[idx]==0)
            {
                return target/arr[idx];
            }
            else
            {
                return 1000000007;
            }
        }
            int notpick = 0 + recur(arr, target, idx-1);

            int pick = Integer.MAX_VALUE;
            if(arr[idx]<=target)
            {
                pick = 1+recur(arr, target-arr[idx],idx);
            }

            return Math.min(notpick, pick);

    }
    public static int memo(int[]arr, int target, int idx,int[][]dp)
    {
        if(idx==0)
        {
            if(target%arr[idx]==0)
            {
                return dp[0][target]=target/arr[idx];
            }
            else {
                return 1000000007;
            }
        }
            if(dp[idx][target]!=-1)
            {
                return dp[idx][target];
            }
            int notpick = 0+ memo(arr, target,idx-1,dp);
            int pick = Integer.MAX_VALUE;
            if(arr[idx]<=target)
            {
                pick = 1+memo(arr, target-arr[idx], idx, dp);
            }
            return dp[idx][target] = Math.min(pick , notpick);


    }
    public static int tabu(int []arr , int target, int n)
    {
        int[][]dp = new int[n][target+1];
        for(int i=0;i<=target;i++)
        {
            if(i%arr[0]==0)
            {
                dp[0][i] = i/arr[0];
            }
            else{
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                int notpick = 0+ dp[i-1][j];
                int pick = Integer.MAX_VALUE;
                if(arr[i]<=j)
                {
                    pick = 1+dp[i][j-arr[i]];
                }
                dp[i][j] = Math.min(pick, notpick);
            }
        }
        return dp[n-1][target];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        int res = recur(arr, target, n-1);
        System.out.println("recur : "+res);

        int[][]dp  = new int[n][target+1];
        for(int[]a :dp)
        {
            Arrays.fill(a,-1);
        }

        int ans = memo(arr,target, n-1, dp);
        System.out.println("memo : "+ans);

        int findans = tabu(arr, target ,n );
        System.out.println("tabu :"+ findans);

    }
}
