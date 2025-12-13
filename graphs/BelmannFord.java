import java.util.*;
public class BelmannFord {// only in directed graph
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // add edges (u → v with weight w)
        adj.get(0).add(new int[]{1, 6});
        adj.get(0).add(new int[]{2, 7});
        adj.get(1).add(new int[]{2, 8});
        // adj.get(1).add(new int[]{3, -4});      // cause negative cycle
        adj.get(2).add(new int[]{3, 9});
        adj.get(2).add(new int[]{4, -3});
        adj.get(3).add(new int[]{1, -2});
        adj.get(4).add(new int[]{3, 7});

        int src = 0;

        int iteration_needed  =  n-1;

        int[]distance = new int[n];
        Arrays.fill(distance,(int)1e8);
        distance[src]=0;

        for(int i=0;i<iteration_needed;i++)   //n-1 iterations 
        {
            for(int j=0;j<adj.size();j++)
            {
                for(int[]edges :adj.get(j))
                {
                    int source = j;
                    int destination = edges[0];
                    int weight = edges[1];

                    //relaxation
                    if(distance[source]!=(int)1e8 &&
                        distance[source]+weight<distance[destination]
                    )
                    {
                        distance[destination] = distance[source]+weight;
                    }


                }
            }
        }

        //for negative cycle detection-> even after the (n-1)iteration if we go furture then the value of distance array changes.
        for(int i=0;i<1;i++)   //n-1 iterations 
        {
            for(int j=0;j<adj.size();j++)
            {
                for(int[]edges :adj.get(j))
                {
                    int source = j;
                    int destination = edges[0];
                    int weight = edges[1];

                    //relaxation
                    if(distance[source]!=(int)1e8 &&
                        distance[source]+weight<distance[destination]
                    )
                    {
                        System.out.println("Negative Cycle Detected");
                        return;
                        // distance[destination] = distance[source]+weight;
                    }


                }
            }
        }


        for(int ele : distance)
        {
            System.out.print(ele+" ");
        }




    }
}
