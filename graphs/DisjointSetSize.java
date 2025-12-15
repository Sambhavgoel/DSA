import java.util.*;
class DisjointSet{
    List<Integer>parent = new ArrayList<>();
    List<Integer>size = new ArrayList<>();

    DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            size.add(1);  // count total number of nodes
            parent.add(i);
        }
    }

    public int ultimateParent(int node)
    {
        if(parent.get(node)==node)
        {
            return node;
        }

        int ultimatep = ultimateParent(parent.get(node));
        parent.set(node,ultimatep);// path compression

        return ultimatep;

    }

    public void unionBySize(int u,int v)
    {
        int ultimate_u = ultimateParent(u);
        int ultimate_v = ultimateParent(v);

        if (ultimate_u == ultimate_v) return;


        if(size.get(ultimate_u)<size.get(ultimate_v))
        {
            parent.set(ultimate_u,ultimate_v);
            size.set(ultimate_v,size.get(ultimate_u)+size.get(ultimate_v));
        }
        else{
            parent.set(ultimate_v,ultimate_u);
            size.set(ultimate_u,size.get(ultimate_u)+size.get(ultimate_v));
        }

    }

}
public class DisjointSetSize {
    public static void main(String args[])
    {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
            System.out.println("Same Parent");
        } else {
            System.out.println("Different Parent");

        }

        ds.unionBySize(3, 7);
        
        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

    }
}
