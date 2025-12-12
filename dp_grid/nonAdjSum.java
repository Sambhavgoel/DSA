import java.util.*;
public class nonAdjSum {
    public static int cal(int n , int[]arr)
    {
        if(n==0) return arr[0];
        if(n<0) return 0;

        int left = cal(n-2,arr)+arr[n];
        int right = cal(n-1,arr);

        return Math.max(left,right);

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans  = cal(n-1,arr);
        System.out.println(ans);
    }
}
