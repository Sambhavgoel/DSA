import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++)// for handling 1 based indexing also
        {
            rank.add(0);
            parent.add(i);
        }
    }

    public int ultimateParent(int node) {
        if (parent.get(node) == node) {
            return node;
        }

        int ultimatep = ultimateParent(parent.get(node));
        parent.set(node, ultimatep); // join all node to their ultimte parent

        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ultimate_u = ultimateParent(u);
        int ultimate_v = ultimateParent(v);

        if (ultimate_u == ultimate_v) return; // both have same parent it means same tree forms
        
        if (rank.get(ultimate_u) < rank.get(ultimate_v)) // get the rank of their parent
        {
            parent.set(ultimate_u, ultimate_v);
        } else if (rank.get(ultimate_v) < rank.get(ultimate_u)) // get the rank of their parent
        {
            parent.set(ultimate_v, ultimate_u);
        } else { // same rank of parent
            parent.set(ultimate_u, ultimate_v);
            int rank_u = rank.get(ultimate_u);
            rank.set(ultimate_u, rank_u + 1);
        }

    }

}

public class DisjointSetRank {
    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet(7); // give the number of node
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
            System.out.println("Same Parent");
        } else {
            System.out.println("Different Parent");

        }

        ds.unionByRank(3, 7);

        if (ds.ultimateParent(3) == ds.ultimateParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }

}
