import java.util.*;
class candy{
    public static void maxcandy(int[]arr)
    {
        int n = arr.length;
        int sum=1;
        int i=1;

        while(i<n)
        {
            if(arr[i]==arr[i-1])
            {
                sum+=1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && arr[i]>arr[i-1])
            {
                peak++;
                sum+=peak;
                i++;
            }
            int down=1;
            while(i<n && arr[i]<arr[i-1])
            {
                sum+=down;
                down++;
                i++;
            }
            if(down>peak)
            {
                sum+=(down-peak);
            }
            // if (peak > 1 && down > 1) {
            //     sum -= Math.min(peak, down);;
            // }
        }
        System.out.println("max : "+sum);
    }
    public static void main(String args[])
    {
        int []arr = {1,0,2};
        maxcandy(arr);
    }
}