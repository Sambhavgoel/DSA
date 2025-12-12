import java.util.*;
public class UndirectedSP{
    public static void main(String args[])
    {
        int N = 9, M = 10;
        int[][] edges = {
            {0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6},
            {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };

        int src=0;

        int[]distance = new int[N];
        Arrays.fill(distance,(int)1e9);

        distance[src]=0;

        List<List<Integer>>adj = new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[]ele : edges)
        {
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
        }

        Queue<Integer>q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty())
        {
            int temp = q.poll();

            for(int ele : adj.get(temp))
            {
                if(1+distance[temp]<distance[ele])
                {
                    distance[ele] = 1+distance[temp];
                    q.add(ele);
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