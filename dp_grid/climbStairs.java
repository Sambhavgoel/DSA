import java.util.*;
public class climbStairs {
    public static int cal(int n)
    {
        if(n==0 || n==1)return 1;
        return cal(n-1)+cal(n-2);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = cal(n);
        System.out.println(ans);

    }
}
