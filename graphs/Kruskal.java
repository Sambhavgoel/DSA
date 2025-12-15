import java.util.*;
class DisjointSet{
    List<Integer>size = new ArrayList<>();
    List<Integer>parent = new ArrayList<>();

    DisjointSet(int V)
    {
        for(int i=0;i<=V;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }

    public int ultimateParent(int node)
    {
        if(parent.get(node)==node)
        {
            return node;
        }
        int ult = ultimateParent(parent.get(node));
        parent.set(node,ult);
        return parent.get(node);
        
    }

    public void findBySize(int u, int v)
    {
        int ultimate_u = ultimateParent(u);
        int ultimate_v = ultimateParent(v);

        if(ultimate_u==ultimate_v)return;

        int size_u = size.get(ultimate_u);
        int size_v = size.get(ultimate_v);

        if(size_u>size_v)
        {
            parent.set(ultimate_v,ultimate_u);
            size.set(ultimate_u,size.get(ultimate_u)+size.get(ultimate_v));
        }
        else{
            parent.set(ultimate_u,ultimate_v);
            size.set(ultimate_v,size.get(ultimate_u)+size.get(ultimate_v));
        }

    }



}
public class Kruskal {
    public static void main(String args[])
    {
        int V = 4;
        int[][] edges = {   //u v w
                {0, 1, 1},
                {1, 2, 2},
                {2, 3, 3},
                {0, 3, 4}
        };

        List<int[]>adj = new ArrayList<>();
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.add(new int[]{w,u,v});
        }

        adj.sort(Comparator.comparingInt(x->x[0]));

        int sum=0;
        DisjointSet ds = new DisjointSet(V);

        for(int i=0;i<adj.size();i++)
        {
            int[]temp = adj.get(i);
            int wt = temp[0];
            int u = temp[1];
            int v = temp[2];

            if(ds.ultimateParent(u)!= ds.ultimateParent(v))
            {
                sum+=wt;
                ds.findBySize(u,v);
            }
        }

        System.out.println(sum);



    }
}
