import java.util.*;
class Besttimebuysell3 {
    public static int recur(int n, int[]arr,int idx, int cap, int buy)
    {
        if(idx==n ||cap==0)return 0;

        int profit =0 ;
        if(buy==0)
        {
            profit = Math.max(-arr[idx]+recur(n,arr,idx+1,cap,1),recur(n,arr,idx+1,cap,0));
        }
        if(buy==1)
        {
            profit = Math.max(arr[idx]+recur(n,arr,idx+1,cap-1,0),recur(n,arr,idx+1,cap,1));
        }
        return profit;
    }
    public static int memo(int n, int[]arr, int idx,int buy,int cap, int[][][]dp)
    {
        if(idx==n||cap==0)return 0;

        if(dp[idx][buy][cap]!=-1)return dp[idx][buy][cap];

        int profit=0;
        if(buy==0)
        {
            profit = Math.max(-arr[idx]+memo(n,arr,idx+1,1,cap,dp),memo(n,arr,idx+1,0,cap,dp));
        }
        if(buy==1)
        {
            profit = Math.max(arr[idx]+memo(n,arr,idx+1,0,cap-1,dp),memo(n,arr,idx+1,1,cap,dp));
        }

        return dp[idx][buy][cap]=profit;

    }
    public static int tabu(int n , int[]arr)
    {
        int[][][]dp = new int[n+1][2][3];

        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                for(int k=1;k<=2;k++)
                {
                    int profit =0 ;
                    if(j==0)
                    {
                        profit = Math.max(-arr[i]+dp[i+1][1][k],dp[i+1][0][k]);
                    }
                    if(j==1)
                    {
                        profit = Math.max(arr[i]+dp[i+1][0][k-1],dp[i+1][1][k]);
                    }
                    dp[i][j][k] = profit;
                }
            }
        }
        return dp[0][0][2];

    }

    public static int so(int n, int[]arr)
    {
        int[][]prev = new int[2][3];

        for(int i=n-1;i>=0;i--)
        {
            int[][]cur = new int[2][3];
            for(int j=0;j<=1;j++)
            {
                for(int k=1;k<=2;k++)
                {
                    int profit = 0 ;
                    if(j==0)
                    {
                        profit = Math.max(-arr[i]+prev[1][k],prev[0][k]);
                    }
                    if(j==1)
                    {
                        profit = Math.max(arr[i]+prev[0][k-1],prev[1][k]);
                    }

                    cur[j][k] = profit;

                }
            }
            prev=cur;
        }
        return prev[0][2];
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
        
        int ans = recur(n,arr,0,2,0);
        System.out.println("ans : "+ans);

        int[][][]dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int res = memo(n,arr,0,0,2,dp);
        System.out.println("memo : "+res);

        int findans=  tabu(n,arr);
        System.out.println("tabu : "+findans);

        int space=  so(n,arr);
        System.out.println("space optimize : "+space);

    }
}
