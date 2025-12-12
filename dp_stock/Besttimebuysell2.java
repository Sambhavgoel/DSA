import java.util.*;
class Besttimebuysell2 {
    public static int recur(int idx, int[]arr, int buy)
    {
        if(idx==arr.length)
        {
            return 0;
        }
        int profit=0;
        if(buy==1)
        {
            profit = Math.max(-arr[idx]+recur(idx+1,arr,0),
                                0+recur(idx+1,arr,1));
        }
        if(buy==0){
            profit = Math.max(arr[idx]+recur(idx+1,arr,1),
                                0+recur(idx+1,arr,0));
        }
        return profit;
    }
    public static int memo(int idx, int[]arr , int buy, int[][]dp)
    {
        if(idx==arr.length)return 0;

        if(dp[idx][buy]!=-1)
        {
            return dp[idx][buy];
        }

        int profit=0;
        if(buy==1)
        {
            profit = Math.max(-arr[idx]+memo(idx+1,arr,0,dp),
                                    0+memo(idx+1,arr,1,dp));
        }
        if(buy==0)
        {
            profit = Math.max(arr[idx]+memo(idx+1,arr,1,dp),
                                0+memo(idx+1,arr,0,dp));
        }
        return dp[idx][buy]=profit;
    }

    public static int tabu(int n, int[]arr)
    {
        int[][]dp = new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                int profit=0;
                if(j==0)
                {
                    profit = Math.max(-arr[i]+dp[i+1][1],0+dp[i+1][0]);
                }
                if(j==1){
                    profit  = Math.max(arr[i]+dp[i+1][0],0+dp[i+1][1]);
                }

                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
    public static  int so(int n, int[]arr)
    {
        int[]prev = new int[2];
        prev[0]=prev[1]=0;
        for(int i=n-1;i>=0;i--)
        {int[]cur = new int[2];
            for(int j=0;j<=1;j++)
            {

                if(j==0)
                {
                    cur[0] = Math.max(-arr[i]+prev[1],prev[0]);
                }
                if(j==1)
                {
                    cur[1] = Math.max(arr[i]+prev[0],prev[1]);
                }


            }
            prev= cur;
        }
        return prev[0];

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
        int ans = recur(0,arr,1);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n][2];
        for(int[]a : dp)
        {
            Arrays.fill(a,-1);
        }

        int res = memo(0,arr,1,dp);
        System.out.println("memo : "+res);

        int findans = tabu(n,arr);
        System.out.println("tabu : "+findans);

        int space = so(n,arr);
        System.out.println("space optimize : "+space);

    }
}
