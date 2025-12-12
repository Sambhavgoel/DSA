import java.util.*;
class Kfrogjump{
    public static int recur(int[]height,int idx,int k)
    {
        if(idx==0)return 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<=k;i++)
        {
            if(idx-i>=0)
            {
                int left = recur(height,idx-i,k)+Math.abs(height[idx-i]-height[idx]);
                ans = Math.min(left,ans);
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n = height.length;
        int k=2;

        recursion
        int ans = recur(height,n-1,k);





        System.out.println(ans);
    }
}