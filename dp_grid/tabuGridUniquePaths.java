import java.util.*;
public class tabuGridUniquePaths {
    public static int optimize(int m,int n, int[]optdp)
    {

        for(int i=0;i<m;i++)
        {
            int[]temp = new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    temp[j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0)up = optdp[j];
                if(j>0)left = temp[j-1];
                temp[j]=up+left;
            }
            optdp=temp;
        }
        return optdp[n-1];
    }
    public static int tabu(int m, int n , int[][]dp)
    {
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
            if(i==0 && j==0){dp[0][0]=1;
            continue;}
                int up=0;
                int left = 0;
                if(i>0)up = dp[i-1][j];
                if(j>0)left = dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n = sc.nextInt();

        int[][]dp = new int[m][n];
        for(int[]i:dp)
        {
            Arrays.fill(i,-1);
        }

        int ans = tabu(m,n,dp);
        System.out.println("ans : "+ans);

        int[]optdp = new int[n];
        Arrays.fill(optdp,0);

        int res = optimize(m,n,optdp);
        System.out.println(res);
    }
}
