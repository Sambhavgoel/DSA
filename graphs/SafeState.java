import java.util.*;
public class SafeState {
    public static void main(String args[])
    {
        List<Integer>[] adj = new ArrayList[12];
        for (int i = 0; i < 12; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1);
        adj[1].add(2);
        adj[2].add(3);
        adj[2].add(4);
        adj[3].add(4);
        adj[4].add(5);
        adj[5].add(6);
        adj[6].add(7);
        adj[8].add(1);
        adj[8].add(9);
        adj[9].add(10);
        adj[10].add(8);
        adj[11].add(9);

        int n = 12;

        ArrayList<ArrayList<Integer>> Revadj = new ArrayList<>();
        int[]indegree = new int[n];

        for(int i=0;i<n;i++)
        {
            Revadj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int ele : adj[i])
            {
                Revadj.get(ele).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        List<Integer>ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            int temp = q.poll();
            ans.add(temp);

            for(Integer it : Revadj.get(temp))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        System.out.println(ans);

    }
}
