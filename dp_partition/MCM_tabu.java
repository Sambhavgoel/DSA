import java.util.*;
class MCM_tabu {
    public static int tabu(int n, int[]arr)
    {
        int[][]dp = new int[n][n];

        for(int i=n-1;i>=1;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                {
                    int steps = (arr[i-1]*arr[k]*arr[j])+dp[i][k]+dp[k+1][j];
                    min = Math.min(min,steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans = tabu(n,arr);
        System.out.println("tabu : "+ans);
    }
}
