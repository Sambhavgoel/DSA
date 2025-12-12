import java.util.*;
class ShortestCommonSupersequence {
    public static String tabu(String s1, String s2, int n, int m)
    {
        int[][]dp =  new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println("length : "+((n+m)-(dp[n][m])));
        StringBuilder ans = new StringBuilder();
        int i=n; int j=m;
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                ans.append(s1.charAt(i-1));
                i--;j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1])
                {
                    ans.append(s1.charAt(i-1));
                    i--;
                }
                else{
                    ans.append(s2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0)
        {
            ans.append(s1.charAt(i-1));
            i--;
        }
        while(j>0)
        {
            ans.append(s2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = s1.length();
        int m = s2.length();

        String ans  = tabu(s1,s2,n,m);
        System.out.println(ans);
    }
}
