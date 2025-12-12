import java.util.*;
class UnboundedKnapsack {
    public static int recur(int[]wt, int[]val, int W,int idx)
    {

        if(idx==0)
        {
            return ((W/wt[0])*val[0]);
        }


        int notpick = 0+recur(wt,val,W,idx-1);
        int pick = Integer.MIN_VALUE;
        if(wt[idx]<=W)
        {
            pick = val[idx]+ recur(wt,val,W-wt[idx],idx);
        }

        return Math.max(pick,notpick);
    }
    public static int memo(int[]wt, int[]val, int W,int[][]dp, int idx)
    {
        if(idx==0)
        {
            return ((W/wt[0])*val[0]);
        }

        if(dp[idx][W]!=-1)
        {
            return dp[idx][W];
        }

        int notpick = 0+memo(wt,val,W,dp,idx-1);
        int pick = Integer.MIN_VALUE;
        if(wt[idx]<=W)
        {
            pick = val[idx]+ memo(wt,val,W-wt[idx],dp,idx);
        }
        return dp[idx][W]=Math.max(pick,notpick);
    }
    public static int tabu(int[]wt , int[]val, int W, int n)
    {
        int[][]dp = new int[n][W+1];
        
        for(int i=wt[0];i<=W;i++)
        {
            dp[0][i] = ((i/wt[0])*val[0]);
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                int notpick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=j)
                {
                    pick = val[i]+ dp[i][j-wt[i]];
                }
                dp[i][j] = Math.max(pick, notpick);
            }
        }
        return dp[n-1][W];
    }
    public static void main(String args[])
    {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        int ans = recur(wt,val,W,n-1);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n][W+1];
        for(int[]a : dp)
        {
            Arrays.fill(a,-1);
        }
        int res = memo(wt,val,W,dp,n-1);
        System.out.println("memo : "+res);

        int findans = tabu(wt,val,W,n);
        System.out.println("tabu : "+findans);


    }
}
