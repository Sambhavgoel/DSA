import java.util.*;
public class DetectCyclebfs {
    static class Pair{
        int node;
        int parent;
        Pair(int node, int parent)
        {
            this.node=node;
            this.parent=parent;
        }
    }
    public static boolean bfs(int start,int parent,ArrayList<ArrayList<Integer>> adj,boolean[]visited)
    {
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(start,-1));
        visited[start]=true;

        while(!q.isEmpty())
        {
            Pair temp = q.poll();

            for(Integer it : adj.get(temp.node))
            {
                if(visited[it]==false){
                    visited[it]=true;
                    q.add(new Pair(it,temp.node));
                }
                else{
                    if(temp.parent!=it)
                    {
                        return true;
                    }
                }
            }

        }
        return false;
    }
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean[]visited = new boolean[5];

        for(int i=0;i<4;i++)
        {
            if(!visited[i])
            {
                if(bfs(i,-1,adj,visited))
                {
                    System.out.println("cycle");
                    return;
                }
            }
        }
        System.out.println("no cycle");

    
    }
}
