import java.util.*;
public class Detectcycledfs {
    
    public static boolean dfs(int node, int parent,boolean[]visited, ArrayList<ArrayList<Integer>>adj)
    {
        visited[node]=true;

        for(Integer it: adj.get(node))
        {
            if(!visited[it])
            {
                if(dfs(it,node,visited,adj))
                {
                    return true;
                }
            }
            else{
                if(it!=parent)
                {
                    return true;
                }
            }
        }
        return false;


    }
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean[]visited = new boolean[4];

        for(int i=0;i<4;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,-1,visited,adj))
                {
                    System.out.println("Cycle Detected");
                    return;
                }
            }
        }
        System.out.println("No Cycle ");

    }
}
