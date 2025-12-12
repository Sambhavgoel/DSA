import java.util.*;
class Besttimebuysell3_n4 {
    public static int recur(int n, int[]arr,int idx, int trans)
    {
        if(idx==n || 0==trans)return 0;

        int profit=0;
        if(trans%2==0)
        {
            profit = Math.max(-arr[idx]+recur(n,arr,idx+1,trans-1),recur(n,arr,idx+1,trans));
        }
        else{
            profit = Math.max(arr[idx]+recur(n,arr,idx+1,trans-1),recur(n,arr,idx+1,trans));
        }
        return profit;

    }
    public static int memo(int n, int[]arr, int idx, int trans,int cap, int[][]dp)
    {
        if(idx==n || cap==trans)return 0;

        if(dp[idx][trans]!=-1)
        {
            return dp[idx][trans];
        }

        int profit=0;
        if(trans%2==0)
        {
            profit = Math.max(-arr[idx]+memo(n,arr,idx+1,trans+1,cap,dp),memo(n,arr,idx+1,trans,cap,dp));
        }
        else{
            profit = Math.max(arr[idx]+memo(n,arr,idx+1,trans+1,cap,dp),memo(n,arr,idx+1,trans,cap,dp));
        }
        return dp[idx][trans]=profit;
    }
    public static int tabu(int n, int[]arr, int cap)
    {
        int trans = 2*cap;
        int[][]dp = new int[n+1][trans+1];

        for(int i=n-1;i>=0;i--)
        {
            for(int j=trans-1;j>=0;j--)
            {
                int profit=0;
                if(j%2==0)
                {
                    profit = Math.max(-arr[i]+dp[i+1][j+1],dp[i+1][j]);
                }
                else{
                    profit = Math.max(arr[i]+dp[i+1][j+1],dp[i+1][j]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
    public static int so(int n, int[]arr, int cap)
    {
        int trans=2*cap;
        int[] prev = new int[trans+1];

        for(int i=n-1;i>=0;i--)
        {
            int[]cur = new int[trans+1];
            for(int j=trans-1;j>=0;j--)
            {
                int profit=0;
                if(j%2==0)
                {
                    profit = Math.max(-arr[i]+prev[j+1],prev[j]);
                }
                else{
                    profit = Math.max(arr[i]+prev[j+1],prev[j]);
                }
                cur[j] = profit;
            } n   
            prev=cur;
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
        int cap=2;
        int ans = recur(n,arr,0,2*cap);
        System.out.println("ans : "+ans);

        int[][]dp = new int[n][2*cap];

        for(int[]a:dp)
        {
            Arrays.fill(a,-1);
        }

        int res = memo(n,arr,0,0,2*cap,dp);
        System.out.println("memo : "+res);

        int findans=  tabu(n,arr,cap);
        System.out.println("tabu : "+findans);

        int space=  so(n,arr,cap);
        System.out.println("space optimize : "+space);
    }
}
