import java.util.*;
public class MakingLargeIsland {
    public static void main(String args[])
    {
        int[][] grid = {
            {1, 0},
            {0, 1}
        };

        int n = grid.length;

        DisjointSet ds  = new DisjointSet(n*n);
// make all connected together
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0) continue;
                
                int[]dr = {0,0,1,-1};
                int[]dc = {1,-1,0,0};

                for(int idx=0;idx<4;idx++)
                {
                    int newr = i+dr[idx];
                    int newc = j+dc[idx];

                    if(newr>=0 && newc>=0 && newr<n && newc<n && grid[newr][newc]==1)
                    {
                        int nodeno = i*n+j;
                        int newnode = newr*n+newc;

                        ds.unionBySize(nodeno, newnode);

                    }
                }

            }
        }
        //now start with the question
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int totsize=0;

                if(grid[i][j]==1)continue;

                int[]dr = {0,0,1,-1};
                int[]dc = {1,-1,0,0};

                Set<Integer>set = new HashSet<>();

                for(int idx=0;idx<4;idx++)
                {
                    int newr = i+dr[idx];
                    int newc = j+dc[idx];

                    if(newr>=0 && newc>=0 && newr<n&& newc<n && grid[newr][newc]==1)
                    {
                        int adjnodeno = newr*n+newc;
                        set.add(ds.ultimateParent(adjnodeno));
                    }

                }

                for(int k: set)
                {
                    totsize+= ds.size.get(k);
                }

                ans = Math.max(totsize+1,ans);




            }
        }
        for(int i=0;i<n*n;i++)
        {
            ans = Math.max(ans,ds.size.get(ds.ultimateParent(i)));
        }

        System.out.println(ans);

    }
}
