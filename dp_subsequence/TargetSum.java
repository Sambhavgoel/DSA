import java.util.*;
class TargetSum {
    public static int tabu(int n ,int[]arr , int target)
    {
        int [][]dp = new int[n][target+1];

        if(arr[0]==0)
        {
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
        }
        if(arr[0]!=0 && arr[0]<=target)
        {
            dp[0][arr[0]]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j =0;j<=target;j++)
            {
                int nottake = dp[i-1][j];
                int take = 0;
                if(arr[i]<=j)
                {
                    take = dp[i-1][j-arr[i]];
                }

                dp[i][j] =  take+nottake;

            }
        }
        return dp[n-1][target];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        int totalsum=0;
        for(int i=0;i<n;i++)
        {
           arr[i] = sc.nextInt();
           totalsum+=arr[i];
        }

        if((totalsum-target)<0 || (totalsum-target)%2==1)
        {
            System.out.println("-1");
            return;
        }
        else{
            int ans = tabu(n,arr, (totalsum-target)/2);
            System.out.println("tabu : "+ans);
        }

    }
}
