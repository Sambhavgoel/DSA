import java.util.*;
class jump2{
    public static void jumps(int[]nums)
    {
        int n = nums.length;
        int l=0;
        int r=0;
        int jumps=0;
        while(r<n-1)
        {
            int max_jump=0;
            for(int i=l;i<=r;i++)
            {
                max_jump = Math.max(max_jump , i+nums[i]);
                
            }
            l=r+1;
            r=max_jump;
            jumps++;
        }
        System.out.println("Jumps : "+jumps);
    }
    public static void main(String args[])
    {
        int[] nums = {2,3,1,4,1,1,1,2}; //3
        jumps(nums);

    }
}