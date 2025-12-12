import java.util.*;
//dfs
public class TopoSort {
    public static void bfs(int idx, int[]visited,Stack<Integer>st,ArrayList<ArrayList<Integer>>adj)
    {
        visited[idx]=1;
        for(Integer it : adj.get(idx))
        {
            if(visited[it]==0)
            {
                bfs(it,visited,st,adj);
            }
        }

        st.push(idx);
    }
    public static void main(String args[])
    {
        int V=6;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Stack<Integer>st = new Stack<>();
        int []visited = new int[V];

        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                bfs(i,visited,st,adj);
            }
        }

        while(!st.isEmpty())
        {
            System.out.println(st.pop());
        }

    }
}
