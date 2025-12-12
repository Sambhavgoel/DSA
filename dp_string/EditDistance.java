import java.util.*;
class EditDistance {

    public static int recur(String s1, String s2, int i, int j)
    {
        if(i<0)
        {
            return j+1;
        }
        if(j<0)
        {
            return i+1;
        }

        if(s1.charAt(i)==s2.charAt(j))
        {
            return recur(s1,s2,i-1,j-1);
        }
        else{
            return Math.min(1+recur(s1,s2,i-1,j),Math.min(1+recur(s1,s2,i,j-1),1+recur(s1,s2,i-1,j-1)));
        }

    }
    public static int memo(String s1, String s2, int i, int j, int[][]dp)
    {
        if(i<0)return j+1;
        if(j<0)return i+1;

        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j] = memo(s1,s2,i-1,j-1,dp);
        }
        else{
            return dp[i][j]= Math.min(1+memo(s1,s2,i-1,j,dp),
                            Math.min(1+memo(s1,s2,i,j-1,dp),
                            1+memo(s1,s2,i-1,j-1,dp)));
        }

    }

    public static int tabu(String s1, String s2, int n, int m)
    {
        int[][]dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++)
        {
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++)
        {
            dp[0][j] = j;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(1+dp[i-1][j],
                            Math.min(1+dp[i][j-1],
                            1+dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = s1.length();
        int m = s2.length();

        int ans = recur(s1,s2,n-1,m-1);
        System.out.println("recur : "+ans);


        int[][]dp = new int[n+1][m+1];
        for(int[]a : dp)
        {
            Arrays.fill(a,-1);
        }

        int res = memo(s1,s2,n-1,m-1,dp);
        System.out.println("memo : "+res);

        int findans = tabu(s1,s2,n,m);
        System.out.println("tabu : "+findans);

    }
}
