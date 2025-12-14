import java.util.*;

public class Prims {
    public static void main(String args[])
    {
        // if sum the mst -> take parent otherwise no need
        // for min. spaning tree
        //pq, mst array, sum, visited array needed
        //update mst array, sum

        int V=5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}; // u v w

        //adj list
        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }

        ArrayList<int[]>MST = new ArrayList<>();
        int[]visited=new int[V];
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int sum=0;

        // visited[0]=1;
        pq.add(new int[]{0,0,-1});    // weight node parent

        while(!pq.isEmpty())
        {
            int[]temp = pq.poll();
            int weight = temp[0];
            int node = temp[1];
            int parent = temp[2];
            //visited
            if(visited[node] == 1)continue;
            visited[node]=1;
            //sum
            sum+=weight;
            //MST
            if(parent != -1)
            {
                MST.add(new int[]{parent,node});
            }

            for(int[]ele : adj.get(node))
            {
                int destination = ele[0];
                int nodeweight = ele[1];
                //added to pq
                if(visited[destination]==0)
                {
                    pq.add(new int[]{nodeweight,destination,node});
                }

            }



        }

        System.out.println("sum : "+sum);

        for(int[]ele : MST)
        {
            System.out.println(ele[0]+" "+ele[1]);
        }





    }
}
