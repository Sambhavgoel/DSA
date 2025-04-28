import java.util.*;
class Climbing_tree{
    // public static int climb(int n)
    // {
    //     if(n==1)return 1;
    //     if(n==0)return 1;

    //     int left = climb(n-1);
    //     int right = climb(n-2);

    //     return left+right;
    // }

    public static int climb(int n)
    {
        if(n==1)return 1;
        if(n==2)return 2;

        int first=1,second=2;

        for(int i=3;i<=n;i++)
        {
            int ans = first+second;
            first=second;
            second = ans;
        }
        return second;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = climb(n);
        System.out.println(ans);
    }
}