import java.util.*;
class MCM {
    public static int recur(int[]arr, int i, int j)
    {
        if(i==j)return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int steps = (arr[i-1]*arr[k]*arr[j])+recur(arr,i,k)+recur(arr,k+1,j);
            min = Math.min(min,steps);
        }
        return min;
    }
    public static int memo(int[]arr ,int i, int j, int[][]dp)
    {
        if(i==j)return 0;

        if(dp[i][j]!=-1)return dp[i][j];

        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int steps = (arr[i-1]*arr[k]*arr[j])+memo(arr,i,k,dp)+memo(arr,k+1,j,dp);
            min = Math.min(min,steps);
        }
        return dp[i][j] = min;
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
        int ans =recur(arr,1,n-1);
        System.out.println("recur : "+ans);

        int[][]dp = new int[n][n];
        for(int[]a : dp)
        {
            Arrays.fill(a,-1);
        }
        int res = memo(arr,1,n-1,dp);
        System.out.println("memo : "+res);
    }
}
