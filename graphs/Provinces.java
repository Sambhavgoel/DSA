
import java.util.*;
public class Provinces {
    // public static int dfs()
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>>connect = new ArrayList<>();
        connect.add(new ArrayList<Integer>());
        connect.get(0).add(0, 1);
        connect.get(0).add(1, 0);
        connect.get(0).add(2, 1);
        connect.add(new ArrayList<Integer>());
        connect.get(1).add(0, 0);
        connect.get(1).add(1, 1);
        connect.get(1).add(2, 0);
        connect.add(new ArrayList<Integer>());
        connect.get(2).add(0, 1);
        connect.get(2).add(1, 0);
        connect.get(2).add(2, 1);
        int v = connect.size();

        ArrayList<ArrayList<Integer>>data = new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            data.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if(connect.get(i).get(j)==1 && i!=j)
                {
                    data.get(i).add(j);
                    data.get(j).add(i);
                }
            }
        }
        
        int[]visited = new int[v];
        int ans =0 ;

        for(int i=0;i<v;i++)
        {
            if(visited[i]==0)
            {
                ans+=1;
                // visited[i]=1;
                dfs(i,visited,data);
            }
        }
        System.out.println("number of provinces : "+ans);
    }
    public static void dfs(int i, int[]visited,ArrayList<ArrayList<Integer>>data)
    {
        visited[i]=1;
        for(Integer it : data.get(i))
        {
            
            if(visited[it]==0)
            {
                // visited[it]=1;
                dfs(it,visited,data);
            }
        }
    }

}
