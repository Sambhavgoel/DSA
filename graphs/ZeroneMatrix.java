import java.util.*;
public class ZeroneMatrix {

    static class Pair{
        int i;
        int j;
        int distance;
        Pair(int i, int j, int distance)
        {
            this.i=i;
            this.j=j;
            this.distance = distance;
        }
    }

    public static void bfs(int[][]grid,int[][]visited, int[][]distance, int n, int m)
    {
        Queue<Pair>q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;


                }
            }
        }

        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            int []dr = {0,0,1,-1};
            int []dc = {1,-1,0,0};

            for(int i=0;i<4;i++)
            {
                int newrow = temp.i+dr[i];
                int newcol = temp.j+dc[i];

                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && visited[newrow][newcol]==0 )
                {
                    q.add(new Pair(newrow,newcol,temp.distance+1));
                    visited[newrow][newcol]=1;
                    distance[newrow][newcol] = temp.distance+1;
                }

            }
        }
 
     
    }
    
    public static void main(String args[])
    {
        // int[][] grid = {
        //     {0,1,1,0},
        //     {1,1,0,0},
        //     {0,0,1,1}
        // };

        // int[][] grid = {
        //     {1,0,1},
        //     {1,1,0},
        //     {1,0,0}
        // };

        int[][]grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int [][]distance = new int[n][m];

        bfs(grid,visited,distance,n,m);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }


    }
}
