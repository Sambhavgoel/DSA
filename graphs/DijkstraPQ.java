import java.util.*;
//Priority queue ->(min heap) : we store {distance,node} so that the minimum distance node is at the top,
//helps to find the shortest path  and with that we have distance array for keeping the track of shortest path. 

public class DijkstraPQ {
    public static void main(String args[])
    {
        int V = 3, E = 3, S = 2;

        // Create adjacency list to represent the graph
        ArrayList<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges to the graph
        adj[0].add(new int[]{1, 1});
        adj[0].add(new int[]{2, 6});
        adj[1].add(new int[]{2, 3});
        adj[1].add(new int[]{0, 1});
        adj[2].add(new int[]{1, 3});
        adj[2].add(new int[]{0, 6});

        // priorityQueue and a distance array for dijkstra algo

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        int[]distance = new int[V];
        Arrays.fill(distance,(int)1e9);

        distance[S]=0;
        // distance, Source
        pq.offer(new int[]{0,S});

        while(!pq.isEmpty())
        {
            int[]cur = pq.poll();
            int dis = cur[0];
            int node = cur[1];

            for(int []edge : adj[node])
            {
                int adjnode = edge[0];
                int weight = edge[1];

                if(dis+weight<distance[adjnode])
                {
                    distance[adjnode] = dis+weight;
                    pq.offer(new int[]{distance[adjnode],adjnode});
                }

            }
        }


        for(int i=0;i<V;i++)
        {
            System.out.print(distance[i]+" ");
        }





    }
}
