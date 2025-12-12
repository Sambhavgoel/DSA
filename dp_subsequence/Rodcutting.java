import java.util.*;
class Rodcutting {
    public static int recur(int n, int[]arr , int idx)
    {
        if(idx==0)
        {
            return (n*arr[0]);
        }


        int notpick = recur(n,arr,idx-1);
        int pick = Integer.MIN_VALUE;
        int rodlen= idx+1;
        if(rodlen<=n)
        {
            pick = arr[idx]+recur(n-rodlen,arr,idx);
        }

        return Math.max(pick,notpick);
    }
    public static int memo(int n, int[]arr, int idx, int[][]dp )
    {

        if(idx==0)
        {
            return n*arr[0];
        }
        if(dp[idx][n]!=-1)
        {
            return dp[idx][n];
        }

        int notpick = memo(n,arr,idx-1,dp);
        int pick = Integer.MIN_VALUE;
        int rodlen = idx+1;
        if(rodlen<n)
        {
            pick = arr[idx]+ memo(n-rodlen,arr,idx,dp);
        }

        return dp[idx][n]=Math.max(pick, notpick);
    }
    public static int tabu(int n, int[]arr)
    {
        int[][]dp = new int[n][n+1];

        for(int i=0;i<=n;i++)
        {
            dp[0][i] = (i*arr[0]);
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<(n+1);j++)
            {
                int notpick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                int rodlen = i+1;
                if(rodlen<=j)
                {
                    pick = arr[i]+ dp[i][j-rodlen];
                }
                dp[i][j] = Math.max(pick, notpick);
            }
        }
        return dp[n-1][n];

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
        
        int ans = recur(n,arr,n-1);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n][n+1];
        for(int[]a : dp)
        {
            Arrays.fill(a,-1);
        }
        int res = memo(n,arr,n-1,dp);
        System.out.println("memo : "+res);

        int findans = tabu(n,arr);
        System.out.println("tabu : "+findans);
    }
}
