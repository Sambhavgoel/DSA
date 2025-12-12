import java.util.*;
public class ninjaFriends {
    public static int recurchoco(int n,int m,int i,int j1,int j2,int[][]matrix)
    {
        if(j1<0||j2<0||j2>=n||j1>=m)
        {
            return (int)Math.pow(-10,9);
        }
        if(i==n-1)
        {
            if(j1==j2)
            {
                return matrix[i][j1];
            }
            else{
                return matrix[i][j1]+matrix[i][j2];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int a=-1;a<=1;a++)
        {
            for(int b=-1;b<=1;b++)
            {
                int ans;
                if(j1==j2)
                {
                    ans = matrix[i][j1]+recurchoco(n,m, i+1, a+j1, b+j2, matrix);
                }
                else{
                    ans = matrix[i][j1]+matrix[i][j2]+recurchoco(n, m, i+1, a+j1, b+j2, matrix);
                }
                max = Math.max(ans,max);

            }

        }
        return max;
    }
    public static int memo(int n,int m,int i,int j1,int j2,int[][]matrix,int[][][]dp)
    {
        if(j1<0||j2<0||j1>=m||j2>=m)
        {
            return (int)Math.pow(-10,9);
        }
        if(i==n-1)
        {
            if(j1==j2) return matrix[i][j1];
            else return matrix[i][j1]+matrix[i][j2];
        }

        if(dp[i][j1][j2] != -1)
        {
            return dp[i][j1][j2];
        }
        int max = Integer.MIN_VALUE;
        for(int a=-1;a<=1;a++)
        {
            for(int b=-1;b<=1;b++)
            {
                int ans;
                if(j1==j2)
                {
                    ans = matrix[i][j1]+memo(n,m,i+1,a+j1,b+j2,matrix,dp);
                }
                else{
                    ans = matrix[i][j1]+matrix[i][j2]+memo(n,m,i+1,j1+a,j2+b,matrix,dp);
                }
                max= Math.max(max,ans);

            }
        }
        return dp[i][j1][j2]=max;

    }
    public static void main(String args[])
    {
        int matrix[][] = {{2, 3, 1, 2},
                        {3, 4, 2, 2},
                        {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(recurchoco(n, m,0,0,n-1, matrix));

        int[][][]dp = new int[n][m][m];
        for(int[][] a:dp)
        {
            for(int[]b:a)
            {
                Arrays.fill(b,-1);
            }
        }
        System.out.println(memo(n,m,0,0,n-1,matrix,dp));

        

    }
}
