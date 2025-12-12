import java.util.*;
class Pair{
    int x;
    int y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y=y;
    }
}
public class NumberofDistinctIsland {
    
    public static void main(String args[])
    {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        int n = grid.length;
        int m= grid[0].length;

        int[][]visited = new int[n][m];

        int ans =0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==0)
                {
                    ans+=1;
                    bfs(visited,grid,i,j);
                }
            }
        }
        System.out.println(ans);
    }
    public static void bfs(int[][]visited,char[][]grid,int i,int j)
    {
        int n = grid.length;
        int m = grid[0].length;

        visited[i][j]=1;

        // int[]dr = {0,0,1,-1,-1,-1,1,1};
        // int[]dc = {1,-1,0,0,-1,1,1,-1};
        int[]dr = {0,0,1,-1};
        int[]dc = {1,-1,0,0};

        for(int dir=0;dir<4;dir++)
        {
            int newx = i+dr[dir];
            int newy = j+dc[dir];

            if(newx>=0 && newy>=0 && newx<n && newy<m && visited[newx][newy]==0 && grid[newx][newy]=='1')
            {
                bfs(visited,grid,newx,newy);
            }

        }
    }
}
