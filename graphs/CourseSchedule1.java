import java.util.*;
public class CourseSchedule1 {
    public static void main(String args[])
    {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[]indegree = new int[numCourses];
        ArrayList<Integer>ans = new ArrayList<>();

        for(int i=0;i<prerequisites.length;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer>q = new LinkedList<>();
        

        for(int i=0;i<prerequisites.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            Integer temp  = q.poll();
            ans.add(temp);
            
            for(Integer it : adj.get(temp))
            {
                indegree[it]--;

                if(indegree[it]==0)
                {
                    q.add(it);
                }

            }

        }
        for(Integer it : ans)
        {
            System.out.println(it+" ");
        }

        if(ans.size()==numCourses)
        {
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }
}
