import java.util.*;
class Countpartitiondiffr {
    public static int recur(int[]arr, int target, int idx)
    {
        if(idx==0)
        {
            if(arr[0]==0 && target==0)return 2;
            if(target==0 || target == arr[0])return 1;
            else return 0;
        }
        int notpick = recur(arr,target,idx-1);
        int pick =0 ;
        if(arr[idx]<=target)
        {
            pick = recur(arr,target-arr[idx],idx-1);
        }
        return pick+notpick;
    }
    public static int memo(int[]arr , int target, int[][]dp ,  int idx)
    {
        if(idx==0)
        {
            if(arr[0]==0 && target==0)return 2;
            if(target==0 ||target==arr[0])return 1;
            return 0;

        }
        if(dp[idx][target]!=-1)return dp[idx][target];

        int notpick = memo(arr,target,dp,idx-1);
        int pick =0 ;
        if(arr[idx]<=target)
        {
            pick = memo(arr, target-arr[idx],dp ,idx-1);
        }
        return dp[idx][target] = pick+notpick;
    }
    public static int tabu(int[]arr,int target , int n )
    {
        int[][]dp = new int[n][target+1];
        if(arr[0]==0)dp[0][0]=2;
        else dp[0][0]=1;

        if(arr[0]!=0 && target >= arr[0])dp[0][arr[0]]=1;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                int notpick  = dp[i-1][j];
                int pick =0 ;
                if(arr[i]<=j)
                {
                    pick = dp[i-1][j-arr[i]];
                }
                dp[i][j]= pick+notpick;
            }
        }
        return dp[n-1][target];

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int totsum=0;
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            totsum+=arr[i];
        }
        if((totsum-d)<0 || ((totsum-d)%2)!=0)
        {
            System.out.println("-1");

        }
        else{
            int ans = recur(arr,(totsum-d)/2,n-1);
            System.out.println("recur : "+ans);

            int target = (totsum-d)/2;
            int[][]dp = new int[n][target+1];
            for(int[] a :dp)
            {
                Arrays.fill(a,-1);
            }

            int res = memo(arr, target,dp, n-1);
            System.out.println("memo : "+res);

            int findans = tabu(arr,target,n);
            System.out.println("tabu : "+findans);
        }

    }
}
