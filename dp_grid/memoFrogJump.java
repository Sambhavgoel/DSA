import java.util.*;
public class memoFrogJump {
    public static int cal(int n , int[] energy,int[]dp)
    {
        if(n==0||n==1)return dp[n];
        if(dp[n]!=-1)return dp[n];

        int left = cal(n-1,energy,dp)+Math.abs(energy[n]-energy[n-1]);
        int right = cal(n-2,energy,dp)+Math.abs(energy[n]-energy[n-2]);

        dp[n] = Math.min(left,right);

        return dp[n];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int [] energy= new int[n];
        for(int i=0;i<n;i++)
        {
            energy[i] = sc.nextInt();
        }
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;

        int ans = cal(n-1,energy,dp);
        System.out.println("ans: "+ans);

    }
}
