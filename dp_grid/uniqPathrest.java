import java.util.*;
public class uniqPathrest {
    public static int recur(int m,int n,int[][]path)
    {
        if(m>=0 && n>=0 && path[m][n]==-1)return 0;
        if(m<0 || n<0)return 0;
        if(m==0 && n==0)return 1;

        int up=0;
        int left=0;
        if(m>0)up=recur(m-1,n,path);
        if(n>0)left = recur(m,n-1,path);

        return up+left;

    }
    public static int dpsol(int m,int n,int[][]path,int[][]dp)
    {
        if(m>=0 && n>=0 && path[m][n]==-1)return 0;
        if(m==0 && n==0)return dp[0][0]=1;
        if(m<0 || n<0)return 0;

        if(dp[m][n]!=-1)return dp[m][n];

        int up=0;
        int left=0;
        if(m>0)up=dpsol(m-1,n,path,dp);
        if(n>0)left= dpsol(m,n-1,path,dp);
        
        return dp[m][n]=left+up;

    }
    public static int tabu(int m,int n,int[][]path,int[][]dp)
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i>=0 && j>=0 && path[i][j]==-1){dp[i][j]= 0;continue;}
                if(i<0 ||j<0)return 0;
                if(i==0&&j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left=0;

                if(i>0)up=dp[i-1][j];
                if(j>0)left=dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    public static int optimize(int m,int n,int[][]path,int[]dp)
    {
        for(int i=0;i<m;i++)
        {
            int []temp= new int[n];
            for(int j=0;j<n;j++)
            {
                if(i>=0&&j>=0&&path[i][j]==-1){temp[j]=0;continue;}
                if(i<0||j<0)return 0;
                if(i==0 && j==0)
                {
                    temp[0]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0)up = dp[j];
                if(j>0)left = temp[j-1];
                temp[j]=up+left;

            }
            dp=temp;
        }
        return dp[n-1];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int mod = (int)Math.pow(10, 9) + 7; 

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
        System.out.println("ans "+ ans%mod);

        int[][]dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int res = dpsol(m-1,n-1,path,dp);
        System.out.println("res "+res%mod);

        int tans = tabu(m,n,path,dp);
        System.out.println("tabu "+tans%mod);


        int[]opt = new int[n];
        Arrays.fill(opt,0);
        int better = optimize(m,n,path,opt);
        System.out.println("better : "+better%mod);




    }
}
