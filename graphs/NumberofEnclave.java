import java.util.*;
public class NumberofEnclave {
    static class Pair{
        int i;
        int j;
        Pair(int i, int j)
        {
            this.i=i;
            this.j=j;
        }
    }

    public static void bfs(int[][]grid, int[][]visited,int n, int m)
    {
        Queue<Pair>q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(grid[0][i]==1)
            {
                q.add(new Pair(0,i));
                visited[0][i]=1;
            }
            if(grid[m-1][i]==1)
            {
                q.add(new Pair(m-1,i));
                visited[m-1][i]=1;
            }
        }
        for(int i=0;i<m;i++)
        {
            if(grid[i][0]==1)
            {
                q.add(new Pair(i,0));
                visited[i][0]=1;
            }
            if(grid[i][n-1]==1)
            {
                q.add(new Pair(i,n-1));
                visited[i][n-1]=1;
            }
        }

        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            int[]dr = {1,-1,0,0};
            int[]dc = {0,0,-1,1};

            for(int i=0;i<n;i++)
            {
                int nr = temp.i+dr[i];
                int nc = temp.j+dc[i];

                if(nr>=0 && nc>=0 && nr<=n && nc<=m && visited[nr][nc]==0 && grid[nr][nc]==1)
                {
                    visited[nr][nc]=1;
                    q.add(new Pair(nr,nc));
                
                }
            }

        }



    }
    
    public static void main(String args[])
    {
        int grid[][] = {
        {0, 0, 0, 0},
        {1, 0, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0}};

        int n = grid.length;
        int m = grid[0].length;

        int[][]visited = new int[n][m];
        int ans=0;

        bfs(grid,visited,n,m);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)
                {
                    ans+=1;
                }
            }
        }
        System.out.println(ans);

    }
}
