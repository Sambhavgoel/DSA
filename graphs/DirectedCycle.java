import java.util.ArrayList;

public class DirectedCycle {
    public static void main(String args[])
    {
        int n = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        int[]visited = new int[n];
        int[]path= new int[n];

        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                if(dfs(i,visited,path,adj)==true)
                {
                    System.out.println("It contains cycle ");
                    return;
                }
                    
            }
        }
        System.out.println("It does not contains cycle ");



    }
    public static boolean dfs(int idx, int []visited, int []path, ArrayList<ArrayList<Integer>>adj){
        visited[idx]=1;
        path[idx]=1;
        for(Integer ele : adj.get(idx))
        {
            if(visited[ele]==0 && path[ele]==0)
            {
                if(dfs(ele,visited,path,adj)==true){
                    return true;
                }
            }
            else if(path[ele]==1)
            {
                return true;
            }
        }
        path[idx]=0;
        return false;

    }
}
