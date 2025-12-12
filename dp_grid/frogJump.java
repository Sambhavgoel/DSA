import java.util.*;
public class frogJump {
    public static int cal(int n,int[]arr)
    {
        if(n==0)return 0;
        if(n==1) return Math.abs(arr[1]-arr[0]);
        int left = cal(n-1,arr)+Math.abs(arr[n]-arr[n-1]);
        int right = cal(n-2,arr)+Math.abs(arr[n]-arr[n-2]);

        return Math.min(left,right);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        int ans = cal(n-1,arr);
        System.out.println("ans"+ans);

    }
}
