import java.util.*;


public class Kahn {
    public static void main(String args[])
    {
        int V = 6;
        
        // Initializing adjacency list with List<List<Integer>>
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding directed edges to the graph
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);


        int[] indegree = new int[V];

        for(int i=0;i<V;i++)
        {
            for(Integer it : adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        ArrayList<Integer>ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            Integer temp = q.poll();
            ans.add(temp);
            for(Integer ele : adj.get(temp))
            {
                indegree[ele]--;
                if(indegree[ele]==0)
                {
                    q.add(ele);
                }
            }
        }

        for(Integer it : ans)
        {
            System.out.print(it+" ");
        }

    }
}
