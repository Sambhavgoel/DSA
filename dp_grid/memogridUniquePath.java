import java.util.*;
public class memogridUniquePath {
    public static int memo(int i,int j,int[][]dp)
    {
        if(i==0 && j==0)return 1;
        if(i<0 || j<0)return 0;

        if(dp[i][j]!=-1)return dp[i][j];

        int up = memo(i-1,j,dp);
        int left = memo(i,j-1,dp);


        return dp[i][j]=up+left;



    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][]dp = new int[m][n];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }

        int ans = memo(m-1,n-1,dp);
        System.out.println("ans : "+ans);
    }
}
