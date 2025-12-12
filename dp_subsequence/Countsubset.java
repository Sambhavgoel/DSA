import java.util.*;
class Countsubset {
    public static int cal(int[] arr, int target, int idx) {
    if (target == 0) return 1;  // ✅ Count the empty subset
    if (idx == 0) {
        return (arr[0] == target) ? 1 : 0;
    }
    int notpick = cal(arr, target, idx - 1);
    int pick = 0;
    if (arr[idx] <= target) {
        pick = cal(arr, target - arr[idx], idx - 1);
    }
    return pick + notpick;
}

    public static int memo(int[]arr, int target, int[][]dp , int idx)
    {
        if(target==0)
        {
            return 1;
        }
        if(idx==0)
        {
            if(target == arr[0])return 1;
            else return 0;
        }
        
        if(dp[idx][target]!=-1)return dp[idx][target];

        int notpick = memo(arr,target,dp,idx-1);
        int pick =0 ;
        if(arr[idx]<=target)
        {
            pick = memo(arr,target-arr[idx],dp,idx-1);
        }
        return dp[idx][target] = pick+notpick ;

    }
    public static int tabu(int n, int[]arr, int target)
    {
        int[][]dp = new int[n][target+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=1;
        }
        if(arr[0]<=target)
        {
            dp[0][arr[0]]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                int notpick = dp[i-1][j];
                int pick=0;
                if(arr[i]<=j)
                {
                    pick = dp[i-1][j-arr[i]];
                }
                dp[i][j] = pick+notpick;
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
        int ans = cal(arr,target,n-1);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n][target+1];
        for(int[]a:dp)
        {
            Arrays.fill(a,-1);
        }
        int res = memo(arr,target,dp,n-1);
        System.out.println("memo :"+res);

        int findans = tabu(n,arr,target);
        System.out.println("tabu : "+findans);
    }
}
