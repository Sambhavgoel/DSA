import java.util.*;
class DisjointSet{
    List<Integer>parent = new ArrayList<>();
    List<Integer>size = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    public int ultimateParent(int node)
    {
        if(parent.get(node)==node)return node;
        int ult = ultimateParent(parent.get(node));
        parent.set(node,ult);
        return parent.get(node);
    }

    public void unionBySize(int u,int v)
    {
        int ultimate_u = ultimateParent(u);
        int ultimate_v = ultimateParent(v);

        if(ultimate_u==ultimate_v)return;

        int size_u = size.get(ultimate_u);
        int size_v = size.get(ultimate_v);

        if(size_u>size_v)
        {
            parent.set(ultimate_v,ultimate_u);
            size.set(ultimate_u,size_u+size_v);
        }
        else{
            parent.set(ultimate_u,ultimate_v);
            size.set(ultimate_v,size_u+size_v);
        }
    }

}
public class NumberOfIslands2 {
    public static void main(String args[])
    {
        int n =4,m=5;
        int[][] operators = {
            {0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };
        // number of distinct island found on connecting these coordinates, left right up down 
        int[][]visited = new int[n][m];
        List<Integer>ans = new ArrayList<>();
        int count=0;  // we increase one then decrease if find any one, left right up down and union it.

        // coordinates to node : row*m+col

        DisjointSet ds = new DisjointSet(n*m);

        //mark the visited node from operators
        for(int i=0;i<operators.length;i++)
        {
            int row = operators[i][0];
            int col = operators[i][1];

            if(visited[row][col]==1)
            {
                ans.add(count);  // in case of same coordinate came more than one time
                continue;
            }

            visited[row][col]=1;
            count+=1;

            int[]dr = {0,0,1,-1};
            int[]dc = {1,-1,0,0};

            for(int idx =0 ;idx<4;idx++)
            {
                int newr = row+dr[idx];
                int newc = col+dc[idx];

                if(newr>=0 && newc>=0 && newr<n && newc<m)
                {
                    if(visited[newr][newc]==1)
                    {
                        int nodeno = row*m+col;
                        int newnodeno = newr*m+newc;
                        if(ds.ultimateParent(nodeno)!=ds.ultimateParent(newnodeno))
                        {
                            count-=1;
                            ds.unionBySize(nodeno,newnodeno);
                        }
                    }
                }
            
            }
            ans.add(count);

        }

        // return ans.stream().mapToInt(i->i).toArray();

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }

    }
}
