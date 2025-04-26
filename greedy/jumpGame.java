import java.util.*;

class jumpGame{
    public static boolean jump(int[]nums)
    {
        int canjump=0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(i>canjump)
            {
                return false;
            }
            if(i<=canjump)
            {
                canjump = Math.max(canjump,i+nums[i]);

            }
        }
        return true;
    }
    public static void main(String args[])
    {
        int[] nums = {4, 3, 7, 1, 2};
        boolean ans = jump(nums);
        System.out.println("Jump: "+ans);
    }
}