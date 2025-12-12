import java.util.*;
public class fallingPathSum {
    public static int recur(int m, int n, int[][]num,int i,int j)
    {
        if(j<0 || j>=n)
        {
            return Integer.MIN_VALUE;
        }
        if(i==0)
        {
            return num[i][j];
        }
        int s = num[i][j]+recur(m,n,num,i-1,j);
        int rd = num[i][j]+recur(m,n,num,i-1,j+1);
        int ld = num[i][j]+recur(m,n,num,i-1,j-1);

        return Math.max(s,Math.max(ld,rd));
    }
    public static int memo(int m,int n,int[][]num,int i,int j,int[][]dp)
    {
        if(j<0||j>=n)return Integer.MIN_VALUE;
        if(i==0)
        {
            return dp[i][j]=num[i][j];
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int s = num[i][j]+memo(m,n,num,i-1,j,dp);
        int dr = num[i][j]+memo(m,n,num,i-1,j+1,dp);
        int dl = num[i][j]+memo(m,n,num,i-1,j-1,dp);

        return dp[i][j]=Math.max(s,Math.max(dl,dr));

    }
    public static int tabu(int m,int n,int[][]num,int i,int j,int[][]dp)
    {
        for(int a=0;a<n;a++)
        {
            dp[0][a]=num[0][a];
        }
        for(int a=1;a<m;a++)
        {
            for(int b=0;b<n;b++)
            {
                // if(b<0||b>=n)return Integer.MIN_VALUE;
                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;
                int s = num[a][b]+dp[a-1][b];
                if(b-1>=0) ld = num[a][b]+dp[a-1][b-1];
                if(b+1<n) rd = num[a][b]+dp[a-1][b+1];
                dp[a][b] = Math.max(s,Math.max(ld,rd));

            }
        }
        int ans = Integer.MIN_VALUE;
        for(int a=0;a<n;a++)
        {
            ans = Math.max(ans,dp[m-1][a]);
        }
        return ans;

    }
    public static int optimize(int m,int n,int[][]num,int i,int j,int[]dp)
    {
        for(int a=0;a<n;a++)
        {
            dp[a]=num[0][a];
        }
        for(int a=1;a<m;a++)
        {
            int[]temp=new int[n];
            for(int b=0;b<n;b++)
            {
                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;
                int s = num[a][b]+dp[b];
                if(b-1>0)ld = num[a][b]+dp[b-1];
                if(b+1<n) rd = num[a][b]+dp[b+1];

                temp[b]=Math.max(s,Math.max(ld,rd));

            }
        }
        int ans=Integer.MIN_VALUE;
        for(int a=0;a<n;a++)
        {
            ans = Math.max(ans,dp[a]);
        }
        return ans;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][]num = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                num[i][j] = sc.nextInt();

            }
        }


        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            ans = Math.max(ans,recur(m,n,num,m-1,i));
        }
        System.out.println("ans: "+ans);



        int[][]dp = new int[m][n];
        for(int[] i:dp)
        {
            Arrays.fill(i,-1);
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            res = Math.max(res,memo(m,n,num,m-1,i,dp));
        }
        System.out.println("res : "+res);


        int tans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            tans = Math.max(res,tabu(m,n,num,0,i,dp));
        }
        System.out.println("tans : "+tans);


        int[]odp = new int[n];
        int opt = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            opt = Math.max(res,optimize(m,n,num,0,i,odp));
        }
        System.out.println("optimize : "+opt);

    }
}
