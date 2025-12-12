import java.util.*;
public class BFS_Undirected {
    public static void bfs(int n, ArrayList<ArrayList<Integer>>data ,ArrayList<Integer>ans)
    {
        boolean visited[] = new boolean[n];
        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans.add(node);

            for(Integer  it : data.get(node))
            {
                if(visited[it]==false)
                {
                    visited[it]=true;
                    q.add(it);
                }
            }

        }

    }
    
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>>data = new ArrayList<>();
        // 5 is the number of nodes
        for(int i=0;i<5;i++)
        {
            data.add(new ArrayList<>());
        }
        data.get(0).add(1);
        data.get(1).add(0);
        data.get(0).add(4);
        data.get(4).add(0);
        data.get(1).add(2);
        data.get(2).add(1);
        data.get(1).add(3);
        data.get(3).add(1);

        ArrayList<Integer>ans = new ArrayList<>();

        bfs(5,data,ans);

        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }

    }

}
