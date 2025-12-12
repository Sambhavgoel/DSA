import java.util.*;
class lis {

    public static int recur(int n, int[]arr , int idx , int prev)
    {
        if(idx>=n)return 0;

        int nottake = recur(n,arr, idx+1,prev);
        int take =0 ;
        if(prev==-1 || arr[idx]>arr[prev])
        {
            take = 1+recur(n,arr,idx+1,idx);
        }

        return Math.max(take,nottake);
    }
    public static int memo(int n, int[]arr,int idx, int prev,int[][]dp)
    {
        if(idx>=n)return 0;

        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];

        int nottake = memo(n,arr,idx+1,prev,dp);
        int take =0 ;
        if(prev==-1|| arr[idx]>arr[prev])
        {
            take = 1+memo(n,arr,idx+1,idx,dp);
        }

        return dp[idx][prev+1]=Math.max(take,nottake);
    }
    public static int tabu(int n, int[]arr)
    {
        int[][]dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--)
        {
            for(int j=i-1;j>=-1;j--)
            {
                int nottake = dp[i+1][j+1];
                int take=0;
                if(j==-1||arr[i]>arr[j])
                {
                    take = 1+dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(take,nottake);
            }
        }
        return dp[0][0];
    }
    public static int so(int n, int[]arr)
    {
        int[] prev= new int[n+1];

        for(int i=n-1;i>=0;i--)
        {
            int []cur = new int[n+1];
            for(int j=i-1;j>=-1;j--)
            {
                int nottake = prev[j+1];
                int take = 0;
                if(j==-1 || arr[i]>arr[j])
                {
                    take = 1+prev[i+1];
                }
                cur[j+1] = Math.max(take,nottake);
            }
            prev=cur;
        }
        return prev[0];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        int ans = recur(n,arr,0,-1);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n][n+1];
        for(int[]a : dp)
        {
            Arrays.fill(a,-1);
        }

        int res = memo(n,arr,0,-1,dp);
        System.out.println("memo : "+res);

        int findans = tabu(n,arr);
        System.out.println( "tabu : "+findans);

        int space = so(n,arr);
        System.out.println("space optimize : "+space);

    }
}
