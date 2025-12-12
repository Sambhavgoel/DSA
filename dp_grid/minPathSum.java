import java.util.*;
public class minPathSum {
    public static int recur(int i,int j,int[][]path)
    {
        if(i==0 && j==0)return path[0][0];
        if(i<0 || j<0)return Integer.MAX_VALUE;

        int up=Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(i>0)up = path[i][j]+recur(i-1,j,path);
        if(j>0)left = path[i][j]+recur(i,j-1,path);

        return Math.min(up,left);



    }
    public static int memo(int i,int j,int[][]path,int[][]dp)
    {
        if(i==0 && j==0 )
        {
            return dp[i][j]=path[0][0];
        }
        if(i<0||j<0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i>0)
        {
            up=path[i][j]+memo(i-1,j,path,dp);
        }
        if(j>0)
        {
            left = path[i][j]+memo(i,j-1,path,dp);
        }
        return dp[i][j]=Math.min(up,left);
    }
    public static int tabu(int m,int n, int[][]path,int[][]dp)
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    dp[0][0]=path[0][0];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0)up = path[i][j]+dp[i-1][j];
                if(j>0)left = path[i][j]+dp[i][j-1];

                dp[i][j] = Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
    }
    public static int optimize(int m,int n,int[][]path,int[]dp)
    {
        for(int i=0;i<m;i++)
        {
            int[] temp = new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    temp[j]=path[i][j];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left =Integer.MAX_VALUE;
                if(i>0)up = path[i][j]+dp[j];
                if(j>0)left = path[i][j]+temp[j-1];
                temp[j] = Math.min(up,left);
            }
            dp=temp;
        }
        return dp[n-1];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][]path = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                path[i][j]=sc.nextInt();
            }
        }
        int ans = recur(m-1,n-1,path);
        System.out.println("ans "+ ans);

        int[][]dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int res = memo(m-1,n-1,path,dp);
        System.out.println("memo: "+res);

        int tans = tabu(m,n,path,dp);
        System.out.println("tabu : "+tans);

        int[]odp= new int[n];
        System.out.println("optimize : "+optimize(m,n,path,odp));


    }
}
