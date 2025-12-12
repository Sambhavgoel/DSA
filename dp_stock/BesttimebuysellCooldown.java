import java.util.*;
class BesttimebuysellCooldown {

    public static int recur(int n, int[]arr, int idx, int buy)
    {
        if(idx>=n)return 0;
        int profit =0 ;
        if(buy==0)
        {
            profit = Math.max(-arr[idx]+recur(n,arr,idx+1,1),recur(n,arr,idx+1,0));
        }
        if(buy==1){
            profit = Math.max(arr[idx]+recur(n,arr,idx+2,0),recur(n,arr,idx+1,1));
        }
        return profit;
    }
    public static int memo(int n, int[]arr,int idx, int buy, int[][]dp)
    {
        if(idx>=n)return 0;

        if(dp[idx][buy]!=-1)return dp[idx][buy];

        int profit=0;

        if(buy==0)
        {
            profit = Math.max(-arr[idx]+memo(n,arr,idx+1,1,dp),memo(n,arr,idx+1,0,dp));
        }
        if(buy==1)
        {
            profit = Math.max(arr[idx]+memo(n,arr,idx+2,0,dp),memo(n,arr,idx+1,1,dp));
        }

        return dp[idx][buy]=profit;
    }
    public static int tabu(int n, int[]arr)
    {
        int [][]dp = new int[n+2][2];

        for(int i=n-1;i>=0;i--)
        {
            // for(int j=1;j>=0;j--)
            // {
            //     int profit =0 ;
            //     if(j==0)
            //     {
            //         profit = Math.max(-arr[i]+dp[i+1][1],dp[i+1][0]);
            //     }
            //     if(j==1)
            //     {
            //         profit = Math.max(arr[i]+dp[i+2][0],dp[i+1][1]);
            //     }
            //     dp[i][j]=profit;
            // }
            int profit =0 ;
            dp[i][0] = Math.max(-arr[i]+dp[i+1][1],dp[i+1][0]);
            dp[i][1] = Math.max(arr[i]+dp[i+2][0],dp[i+1][1]);
        }
        return dp[0][0];
    }
    public static int so(int n, int[]arr)
    {

        int[] front1 = new int[2];
        int[] front2 = new int[2];


        for(int i=n-1;i>=0;i--)
        {
            int[] cur = new int[2];
            int profit =0 ;

            cur[0] = Math.max(-arr[i]+front1[1],front1[0]);
            cur[1] = Math.max(arr[i]+front2[0],front1[1]);

            front2=front1;
            front1=cur;

        }
        return front1[0];
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
        
        
        int ans  = recur(n,arr,0,0);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n+1][2];
        for(int[]a :dp)
        {
            Arrays.fill(a,-1);
        }

        int res = memo(n,arr,0,0,dp);
        System.out.println("memo : "+res);

        int findans = tabu(n,arr);
        System.out.println("tabu : "+findans);

        int space = so(n,arr);
        System.out.println("space optimize : "+space);

        //..................  tabu and so working, but logically incorrect  ............................

    }
}
