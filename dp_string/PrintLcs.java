import java.util.*;
class PrintLcs {
    public static String tabu(String s1,String s2, int n, int m)
    {
        int[][]dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=0;
        }
        for(int i=0;i<=m;i++)
        {
            dp[0][i]=0;
        }
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

        int len = dp[n][m];
        StringBuilder sb = new StringBuilder("");
        int i=n;
        int j=m;

// ..................................................................................
        // while(i>0 && j>0)
        // {
        //     if(s1.charAt(i-1)==s2.charAt(j-1))
        //     {
        //         sb.append(s1.charAt(i-1));
        //         i--;j--;
        //     }
        //     else{
        //         if(dp[i-1][j]>dp[i][j-1])
        //         {
        //             i=i-1;
        //         }
        //         else{
        //             j=j-1;
        //         }
        //     }
        // }
        // sb.reverse();
        // return sb.toString();
        // .........................................................

        char[] ans = new char[len];
        for(int a=0;a<len;a++)
        {
            ans[a]='$';
        }
        int index=len-1;

        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                ans[index] = s2.charAt(j-1);
                index--;
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1])i--;
                else j--;
            }
        }

        return new String(ans);

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = s1.length();
        int m = s2.length();

        String ans = tabu(s1,s2,n,m);
        System.out.println(ans);

    }
}
