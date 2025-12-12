import java.util.*;
class Besttimebuysell4 {
    public static int recur(int n, int[]arr, int idx,int trans)
    {
        if(idx==n||trans==0)return 0;

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
    public static int memo(int n, int[]arr, int idx,int trans, int[][]dp)
    {
        if(idx==n || trans==0)return 0;

        if(dp[idx][trans]!=-1)return dp[idx][trans];

        int profit =0 ;
        if(trans%2==0)
        {
            profit = Math.max(-arr[idx]+memo(n,arr,idx+1,trans-1,dp),memo(n,arr,idx+1,trans,dp));

        }
        else{
            profit = Math.max(arr[idx]+memo(n,arr,idx+1,trans-1,dp),memo(n,arr,idx+1,trans,dp));
        }

        return dp[idx][trans] = profit;

    }
    public static int tabu(int n, int[]arr, int trans)
    {
        int[][]dp = new int[n+1][trans+1];

        for(int i=n-1;i>=0;i--)
        {
            for(int j=1;j<=trans;j++)
            {
                int profit=0; 
                if(j%2==0)
                {
                    profit = Math.max(-arr[i]+dp[i+1][j-1],dp[i+1][j]);
                }
                else{
                    profit = Math.max(arr[i]+dp[i+1][j-1],dp[i+1][j]);
                }
                dp[i][j]=profit;
            }
        }
        return dp[0][trans];

    }
    public static int so(int n, int[]arr, int trans)
    {
        int[]prev = new int[trans+1];

        for(int i=n-1;i>=0;i--)
        {
            int[]cur = new int[trans+1];
            for(int j=1;j<=trans;j++)
            {
                int profit=0;
                if(j%2==0)
                {
                    profit = Math.max(-arr[i]+prev[j-1],prev[j]);
                }
                else{
                    profit = Math.max(arr[i]+prev[j-1],prev[j]);
                }
                cur[j]=profit;
            }
            prev=cur;
        }
        return prev[trans];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        int cap = 2*k;
        int ans  = recur(n,arr,0,cap);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n+1][cap+1];
        for(int[]a :dp)
        {
            Arrays.fill(a,-1);
        }

        int res = memo(n,arr,0,cap,dp);
        System.out.println("memo : "+res);

        int findans = tabu(n,arr,cap);
        System.out.println("tabu : "+findans);

        int space = so(n,arr,cap);
        System.out.println("space optimize : "+space);

        //..................  tabu and so working, but logically incorrect  ............................

    }
}
