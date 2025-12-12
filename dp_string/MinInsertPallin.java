import java.util.*;
public class MinInsertPallin {
    public static int tabu(int n, String s)
    {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();

        int[][]dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int len = dp[n][n];
        return n-len;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int ans = tabu(n,s);
        System.out.println("tau : "+ans);
    }
}
