import java.util.*;
public class DFS_Undirected {

    public static void dfs(int node,boolean[]vis, ArrayList<ArrayList<Integer>> data, 
    ArrayList<Integer> ans)
    {
        vis[node]=true;
        ans.add(node);

        for(Integer it  : data.get(node))
        {
            if(vis[it]==false)
            {
                dfs(it,vis,data,ans);
            }
        }
    }
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            data.add(new ArrayList<>());
        }
        data.get(0).add(2);
        data.get(2).add(0);
        data.get(0).add(1);
        data.get(1).add(0);
        data.get(0).add(3);
        data.get(3).add(0);
        data.get(2).add(4);
        data.get(4).add(2);

        ArrayList<Integer>ans = new ArrayList<>();
        boolean visited[] = new boolean[6];

        // 0 is the starting node
        dfs(0,visited,data,ans);

        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }



    }
}
