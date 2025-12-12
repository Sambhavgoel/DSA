import java.util.*;
class BesttimetobuysellTransFee {
    public static int tabu(int n, int[]arr, int fee)
    {
        int[]front1 = new int[2];
        

        for(int i=n-1;i>=0;i--)
        {
            int[]cur = new int[2];

            cur[0] = Math.max(-arr[i]+front1[1],front1[0]);
            cur[1] = Math.max(arr[i]+front1[0]-fee,front1[1]);

            front1=cur;
        }
        return front1[0];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fee = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        int ans = tabu(n,arr,fee);
        System.out.println("ans : "+ans);
    }
}
