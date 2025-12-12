import java.util.*;
public class Partitionequalsubsetsum {
    public static boolean memo(int[]arr,int target,int idx,int[][]dp)
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
        boolean nottake = memo(arr,target,idx-1,dp);
        boolean take=false;
        if(target>=arr[idx])
        {
            take = memo(arr,target-arr[idx],idx-1,dp);
        }
        dp[idx][target]=(take||nottake)?1:0;
        return take||nottake;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int totalsum=0;
        int []arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            totalsum+=arr[i];
        }
        if(totalsum%2!=0){
            System.out.println("false");
            return;
        }
        int target=(totalsum/2);

        int[][]dp = new int[n][target+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        boolean ans = memo(arr,target,n-1,dp);
        System.out.println(ans);

    }
}
