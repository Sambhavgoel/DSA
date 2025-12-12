import java.util.*;
public class tabuFrogJump {
    public static int cal(int n, int[]energy,int[] dp)
    {
        for(int i=1;i<n;i++)
        {
            int left = dp[i-1]+Math.abs(energy[i]-energy[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1)
            {
                right = dp[i-2]+Math.abs(energy[i]-energy[i-2]);
            }
            dp[i] = Math.min(left,right);
        }
        return dp[n-1];
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
        Arrays.fill(dp,0);

        int ans = cal(n,energy,dp);
        System.out.println("ans: "+ans);
    }
}
