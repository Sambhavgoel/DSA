import java.util.*;
public class AlienDictionary {
    public static void main(String args[])
    {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<K;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<K-1;i++)
        {
            String str1 = dict[i];
            String str2 = dict[i+1];
            int len = Math.min(str2.length(),str1.length());
            for(int j=0;j<len;j++)
            {
                if(str1.charAt(j)!=str2.charAt(j))
                {
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
        }

        int[]indegree = new int[K];
        for(int i=0;i<K;i++)
        {
            for(Integer it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<K;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        ArrayList<Integer>ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            int temp  =q.poll();

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

        for(int i=0;i<K;i++)
        {
            System.out.print(((char)(ans.get(i)+'a')+" "));
        }

    }
}
