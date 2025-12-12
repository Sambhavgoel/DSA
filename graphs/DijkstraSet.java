import java.util.*;
public class DijkstraSet {
    public static void main(String args[])
    {
        int V=3 , E=3, S=2;
        ArrayList<int[]>[]adj = new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            adj[i]=(new ArrayList<>());
        }

        adj[0].add(new int[]{1, 1});
        adj[0].add(new int[]{2, 6});
        adj[1].add(new int[]{2, 3});
        adj[1].add(new int[]{0, 1});
        adj[2].add(new int[]{1, 3});
        adj[2].add(new int[]{0, 6});

        TreeSet<int[]>set = new TreeSet<>((a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return a[1]-b[1];
        });

        int[]distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[S]=0;
        set.add(new int[]{0,S});

        while(!set.isEmpty())
        {
            int[]temp = set.pollFirst();
            int tempdis = temp[0];
            int tempsrc = temp[1];

            for(int []node : adj[tempsrc])
            {
                int tempnode = node[0];
                int weight = node[1];
                if(tempdis+weight<distance[tempnode])
                {
                    if(distance[tempnode]!=Integer.MAX_VALUE)
                    {
                        set.remove(new int[]{distance[tempnode],tempnode});
                    }
                    distance[tempnode] = tempdis+weight;
                    set.add(new int[]{distance[tempnode],tempnode});
                }
            }

        }

        for(int i=0;i<V;i++)
        {
            System.out.print(distance[i]+" ");
        }

    }
}
