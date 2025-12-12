import java.util.*;
public class minPathSuminTri {
    public static int recur(int[][]tri,int n,int i,int j)
    {
        if(i==n)
        {
            return tri[i][j];
        }
        int down = tri[i][j]+recur(tri,n,i+1,j);
        int diagonal = tri[i][j]+recur(tri,n,i+1,j+1);

        return Math.min(down,diagonal);
    }
    public static int memo(int[][]tri,int n,int i,int j,int[][]dp)
    {
        if(i==n)
        {
            return dp[i][j]=tri[i][j];
        }
        if(dp[i][j]!=-1)return dp[i][j];

        int down = tri[i][j]+memo(tri,n,i+1,j,dp);
        int diagonal = tri[i][j]+memo(tri,n,i+1,j+1,dp);

        return dp[i][j] = Math.min(down,diagonal);

    }
    public static int tabu(int[][]tri,int n, int a,int b,int[][]dp)
    {
        for(int i=0;i<n;i++)
        {
            dp[n][i]=tri[n][i];
        }

        for(int i=n-1;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down = tri[i][j]+dp[i+1][j];
                int diag = tri[i][j]+dp[i+1][j+1];
                dp[i][j] = Math.min(down,diag);
            }
        }
        return dp[0][0];

    }
    public static int optimize(int[][]tri,int n,int a,int b,int[]prev)
    {
        for(int i=0;i<n;i++)
        {
            prev[i]=tri[n-1][i];
        }
        for(int i=n-2;i>=0;i--)
        {
            int[]temp = new int[n-1];
            for(int j=i;j>=0;j--)
            {
                int down = tri[i][j]+prev[j];
                int diag = tri[i][j]+prev[j+1];

                temp[j]=Math.min(down,diag);
            }
            prev=temp;
        }
        return prev[0];
    }
    public static void main(String args[])
    {
        int tri[][] = {{1},
                        {2, 3},
                        {3, 6, 7},
                        {8, 9, 6, 10}};

        int n = tri.length;

        int ans = recur(tri,n-1,0,0);
        System.out.println(ans);

        int[][]dp = new int[n][n];
        for(int[]i:dp)
        {
            Arrays.fill(i,-1);
        }
        int res = memo(tri,n-1,0,0,dp);
        System.out.println(res);

        int tans=tabu(tri,n-1,0,0,dp);
        System.out.println(tans);

        int[]prev=new int[n];
        int optans = optimize(tri,n,0,0,prev);
        System.out.println(optans);


    }
}
