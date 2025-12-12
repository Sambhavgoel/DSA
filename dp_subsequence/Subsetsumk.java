import java.util.*;
class Subsetsumk {
    public static boolean tabu(int[]arr, int target)
    {
        int n = arr.length;
        boolean[][]dp = new boolean[n][target+1];

        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }
        if(arr[0]<=target)(dp[0][arr[0]])=true;

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean nottake = dp[i-1][j];
                boolean take = false;
                if(arr[i]<=j)
                {
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take||nottake;
            }
        }
        return dp[n-1][target];
    }
    public static boolean memo(int[]arr, int target, int idx, int[][]dp)
    {
        if(idx==0)
        {
            return (target==arr[0]);
        }
        if(target==0)
        {
            return true;
        }
        if(dp[idx][target]!=-1)
        {
            return dp[idx][target]==0?false:true;
        }
        boolean take = memo(arr,target,idx-1,dp);
        boolean nottake=false;
        if(target>=arr[idx])
        {
            take = memo(arr,target-arr[idx],idx-1,dp);
        }

        dp[idx][target] = (take||nottake)?1:0;

        return take||nottake;
    }
    public static boolean cal(int[]arr, int target,int idx)
    {
        if(idx==0)
        {
            return target==arr[0];
        }
        if(target==0)
        {
            return true;
        }

        boolean nottake = cal(arr,target,idx-1);
        boolean take = false;
        if(arr[idx]<=target)
        {
            take = cal(arr,target-arr[idx],idx-1);
        }

        return take||nottake;


    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
                int target = sc.nextInt();

        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        boolean ans = cal(arr,target,n-1);
        System.out.println(ans);

        int[][]dp = new int[n][target+1];
        for(int[]a:dp)
        {
            Arrays.fill(a,-1);
        }

        boolean ansmemo = memo(arr,target,n-1,dp);
        System.out.println(ansmemo);

        boolean res = tabu(arr,target);
        System.out.println(res);
    }
}
