import java.util.*;

public class PrintSP {
    public static void main(String args[])
    {
        // int V=5;
        int V=3;
        ArrayList<int[]>[]adj = new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            adj[i]=(new ArrayList<>());
        }

        // adj[0].add(new int[]{1, 4});
        // adj[0].add(new int[]{2, 8});

        // adj[1].add(new int[]{0, 4});
        // adj[1].add(new int[]{4, 6});

        // adj[2].add(new int[]{0, 8});
        // adj[2].add(new int[]{3, 2});

        // adj[3].add(new int[]{2, 2});
        // adj[3].add(new int[]{4, 10});

        // adj[4].add(new int[]{1, 6});
        // adj[4].add(new int[]{3, 10});



        adj[0].add(new int[]{1, 1});
        adj[0].add(new int[]{2, 6});
        adj[1].add(new int[]{2, 3});
        adj[1].add(new int[]{0, 1});
        adj[2].add(new int[]{1, 3});
        adj[2].add(new int[]{0, 6});

        int[]distance = new int[V];
        int[]parent = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        for(int i=0;i<V;i++)
        {
            parent[i]=i;
        }
        TreeSet<int[]>set = new TreeSet<>((a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return a[1]-b[1];
        });

        set.add(new int[]{0,0});

        while(!set.isEmpty())
        {
            int[]value = set.pollFirst();
            int dis = value[0];
            int node = value[1];

            for(int[]temp : adj[node])
            {
                int adjnode = temp[0];
                int weight = temp[1];

                if(dis+weight<distance[adjnode])
                {
                    //set.removeIf(a->a[1]==adjnode);
                    if(distance[adjnode]!=Integer.MAX_VALUE)
                    {
                        set.remove(new int[]{distance[adjnode],adjnode});
                    }
                    distance[adjnode] = dis+weight;
                    parent[adjnode]=node;
                    set.add(new int[]{distance[adjnode],adjnode});
                }
            }
        }
        int node = V-1;
        ArrayList<Integer>ans = new ArrayList<>();
        while(parent[node]!=node)
        {
            ans.add(node);
            node = parent[node];
        }
        ans.add(node);
        Collections.reverse(ans);
        for(int i=0;i<ans.size();i++)
        {

            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<V;i++)
        {
            
            System.out.print(distance[i]+" ");
        }



    }
}
