
import java.util.*;
public class RottenOrange {
    static class Pair
    {
        int i;
        int j;
        int t;
        Pair(int i, int j, int t)
        {
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public static void main(String args[])
    {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        // 0 - empty
        // 1 - fresh
        // 2 - rotten
        //dfs
        int n = arr.length;
        int m = arr[0].length;
        Queue<Pair> queue= new LinkedList<Pair>();
        int[][]visited = new int[n][m];

        int before=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==2)
                {
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                if(arr[i][j]==1)
                {
                    before+=1;

                }

            }
        }
        if(queue.size()==0)
        {
            System.out.println("-1");
            return;
        }
        int after=0;
        int ans=0;
        while(!queue.isEmpty())
        {

            Pair p = queue.poll();

            int[]dr = {0,0,-1,1};
            int[]dc = {1,-1,0,0};
            for(int i=0;i<4;i++)
            {
                int t = p.t;
                int nrow = p.i + dr[i];
                int ncol = p.j + dc[i];

                if(nrow>=0&& ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0 && arr[nrow][ncol]==1)
                {
                    after+=1;
                    visited[nrow][ncol]=1;
                    arr[nrow][ncol]=2;
                    queue.add(new Pair(nrow,ncol,t+1));
                    ans=Math.max(ans,t+1);
                }
            }
        }
        if(before==after)
        {
            System.out.println("Time : "+ans);
        }
        else{
            System.out.println("-1");
        }

    }
}
