import java.util.*;
public class BipartiteGraph {
    public static void main(String argss[])
    {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList < > ());
        }
        // adj.get(0).add(2);
        // adj.get(2).add(0);
        // adj.get(0).add(3);
        // adj.get(3).add(0);
        // adj.get(1).add(3);
        // adj.get(3).add(1);
        // adj.get(2).add(3);
        // adj.get(3).add(2);

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(5);
        adj.get(5).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(6);
        adj.get(6).add(3);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(6).add(7);
        adj.get(7).add(6);

        //check for bipartite graph

        int n = adj.size();
        int[]color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(bfs(i,color,0,adj)==true)
                {
                    System.out.println("Bipatite graph");
                    return;
                }
            }
        }
        System.out.println("Bipatite graph");
    }
    public static boolean bfs(int idx,int[]color,int colour,ArrayList < ArrayList < Integer >> adj)
    {
        color[idx]=colour;

        for(Integer it : adj.get(idx))
        {
            if(color[it]==-1)
            {
                if(bfs(it,color,1-colour,adj)==true)
                {
                    return true;
                }
            }
            else{
                if(colour == color[it])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
