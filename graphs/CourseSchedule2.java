import java.util.*;
public class CourseSchedule2 {
    public static void main(String args[])
    {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        int[]indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        ArrayList<Integer>ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            int temp = q.poll();
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

        for(Integer ele : ans)
        {
            System.out.print(ele+" ");
        }


    }
}
