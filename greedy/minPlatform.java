import java.util.*;
class minPlatform{
    public static void platform(int[]arr, int[]dep)
    {
        int i=0;
        int j=0;
        int n=arr.length;
        int count=0;
        int ans=0;
        while(i<n && j<n)
        {
            if(arr[i]<=dep[j])
            {
                i++;
                count=count+1;
            }
            else
            {
                j++;
                count=count-1;
            }
            // System.out.print(count);
            ans=Math.max(ans,count);
        }
        System.out.println("Platform : "+ans);
    }
    public static void main(String args[])
    {
        int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
        Arrays.sort(arr);
        Arrays.sort(dep);
        platform(arr,dep);
    }
}