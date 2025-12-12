import java.util.*;
class Frog_jump{
    public static int solution(int[]height,int idx)
    {
        if(idx==0)return 0;

        int right = Integer.MAX_VALUE;
        int left = solution(height,idx-1)+Math.abs(height[idx]-height[idx-1]);
        if(idx>1)
        {
            right = solution(height,idx-2)+Math.abs(height[idx]-height[idx-2]);
        }

        return Math.max(left,right);

    }
    public static int memo(int[]height,int idx,int[]dp)
    {
        if(idx==0)return 0;
        if(dp[idx]!=-1)return dp[idx];

        int right = Integer.MAX_VALUE;
        int left = memo(height,idx-1,dp)+Math.abs(height[idx]-height[idx-1]);

        if(idx>1)
        {
            right = memo(height,idx-2,dp)+Math.abs(height[idx]-height[idx-2]);
        }

        return dp[idx] = Math.min(left,right);


    }
    public static int tabu(int[]height,int idx,int[]dp)
    {
        dp[0]=0;

        for(int i=1;i<=idx;i++)
        {
            int left = dp[i-1]+Math.abs(height[i]-height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1)
            {
                right = dp[i-2]+Math.abs(height[i]-height[i-2]);
            }
            dp[i] = Math.min(left,right);
        }
        return dp[idx];

    }
    public static int spaceopti(int[]height,int n)
    {
        int prev2=0,prev1 = 0;
        
        for(int i=1;i<n;i++)
        {
            int left = prev1+Math.abs(height[i]-height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1)
            {
                right = prev2+Math.abs(height[i]-height[i-2]);
            }
            prev2=prev1;
            prev1=Math.min(left,right);

        }
        return prev1;
    }
    public static void main(String args[])
    {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n = height.length;
        
        //recursion
        // int ans = solution(height,n-1);

        //memoization
        // int[]dp = new int[n];
        // Arrays.fill(dp,-1);
        // int ans = memo(height,n-1,dp);
        

        //tabu
        // int[]dp = new int[n];
        // Arrays.fill(dp,-1);
        // int ans = tabu(height,n-1,dp);


        //space optimization
        // int ans = spaceopti(height,n);
        // System.out.println(ans);



    }
}