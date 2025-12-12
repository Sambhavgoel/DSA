import java.util.*;
public class SurroundedMatrix {
    public static void dfs(char[][]mat, int[][]visited, char[][]ans, int n, int m)
    {
        visited[n][m]=1;
        ans[n][m]='O';

        int[]dr = {0,0,1,-1};
        int[]dc = {1,-1,0,0};
        for(int i=0;i<4;i++)
        {
            int nr = n+dr[i];
            int nc = m+dc[i];

            if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && visited[nr][nc]==0 && mat[nr][nc]=='O')
            {
                visited[nr][nc]=1;
                ans[nr][nc]='O';
                dfs(mat,visited,ans,nr,nc);
            }
        }
    }
    public static void main(String args[]){

        char mat[][] = {
        {'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'X', 'O', 'O'}};

        int n = mat.length;
        int m  = mat[0].length;

        int[][]visited = new int[n][m];
        char[][]ans = new char[n][m];

        //first and last row

        for(int i=0;i<m;i++)
        {
            if(mat[0][i]=='O')
            {

                dfs(mat,visited,ans,0,i);
            }
            if(mat[n-1][i]=='O')
            {
                dfs(mat,visited,ans,n-1,i);
            }
        }
//first and last column
        for(int i=0;i<n;i++)
        {
            if(mat[i][0]=='O')
            {
                dfs(mat,visited,ans,i,0);
            }
            if(mat[i][m-1]=='O')
            {
                dfs(mat,visited,ans,i,m-1);
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0)
                {
                    ans[i][j]='X';
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }


        
    
    }
}
