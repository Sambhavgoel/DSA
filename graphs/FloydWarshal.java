import java.util.*;
public class FloydWarshal {
    public static void main(String args[])
    {
        int[][] matrix = {
            { 0,  3, -1,  7 },
            { 8,  0,  2, -1 },
            { -1, -1, 0,  1 },
            { 2, -1, -1, 0 }
        };

        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==-1)matrix[i][j] = (int)1e9;
            }
        }

        for(int k = 0 ; k < n ;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        //for negative cycle-> for diagonal elements weight should be -ve.

        for(int i=0;i<n;i++)
        {
            if(matrix[i][i]<0)
            {
                System.out.println("Negatice Cycle Detected");
                return;
            }
        }


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }



        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==(int)1e9)matrix[i][j] = -1;
            }
        }

    }
}
