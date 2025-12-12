import java.util.*;
public class DirectedSP {
    public static void topo(int idx, List<List<int[]>>adj, boolean[]visited, Stack<Integer>stk )
    {
        visited[idx]=true;

        for(int[]ele : adj.get(idx))
        {
            if(!visited[ele[0]])
            {
                topo(ele[0],adj,visited,stk);
            }
        }
        stk.push(idx);
    }
    public static void main(String args[])
    {
        int N = 6, M = 7;
        
        // Edge list with weights
        int[][] edges = {
            {0,1,2}, {0,4,1}, {4,5,4},
            {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}
        };

        List<List<int[]>>adj = new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];

            adj.get(u).add(new int[]{v,weight});

        }

        boolean[]visited = new boolean[N];

        Stack<Integer>stk = new Stack<>();

        for(int i=0;i<N;i++)
        {
            if(!visited[i])
            {
                topo(i,adj,visited,stk);
            }
        }

        int[]distance = new int[N];
        Arrays.fill(distance,(int)1e9);
        distance[0]=0;

        while(!stk.isEmpty())
        {
            int ele = stk.pop();
            if(distance[ele]!=(int)1e9)
            {
                for(int[] temp : adj.get(ele))
                {
                    int v = temp[0];
                    int weight = temp[1];

                    if(weight+distance[ele]<distance[v])
                    {
                        distance[v] = weight+distance[ele];
                    }

                }
            }

        }

        for(int i=0;i<N;i++)
        {
            if(distance[i]==(int)1e9)
            {
                distance[i]=-1;
            }
            System.out.print(distance[i]+" ");
        }


    }
}
