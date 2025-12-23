import java.util.*;
class Trie{
    private Trie[]links;
    Trie()
    {
        links = new Trie[2];
    }

    public boolean containsKey(int bit)
    {
        return links[bit]!=null ;
    }
    public Trie get(int bit)
    {
        return links[bit];
    }
    public void add(int bit , Trie node)
    {
        links[bit]=node;
    }

}
class Node{
    private Trie root;
    Node()
    {
        root = new Trie();
    }

    public void insert(int num)
    {
        Trie node = root;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            if(!node.containsKey(bit))
            {
                node.add(bit , new Trie());
            }
            node = node.get(bit);
        }
    }
    public int getMax(int num)
    {
        Trie node = root ;
        int ans =0 ;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            if(node.containsKey(1-bit))
            {
                ans = ans|(1<<i);
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return ans;
    }
}
class Solution{
    public List<Integer> maxXorQueries(List<Integer> arr, List<List<Integer>> queries)
    {
        List<Integer>ans = new ArrayList<>(Collections.nCopies(queries.size(),0));

        Node node = new Node();

        Collections.sort(arr);
        List<int[]>offlinequeries = new ArrayList<>();
        for(int i=0;i<queries.size();i++)
        {
            offlinequeries.add(new int[]{queries.get(i).get(1),queries.get(i).get(0),i});// xi ai index
        }

        Collections.sort(offlinequeries,Comparator.comparingInt(a->a[0]));

        int index=0;
        int n = arr.size();

        for(int[]it : offlinequeries)
        {
            while(index<n && arr.get(index)<=it[0])
            {
                node.insert(arr.get(index));
                index++;
            }
            if(index!=0)
            {
                ans.set(it[2],node.getMax(it[1]));

            }
            else{
                ans.set(it[2],-1);
            }
        }
        return ans;



    }
}
// Driver class
public class MaxXor {
    public static void main(String[] args) {
        // Example array
        List<Integer> arr = Arrays.asList(3, 10, 5, 25, 2, 8);

        // Display the given array
        System.out.println("Given Array: " + arr);

        // Queries in {x, m} format
        List<List<Integer>> queries = Arrays.asList(
            Arrays.asList(0, 1), Arrays.asList(1, 2),
            Arrays.asList(0, 3), Arrays.asList(3, 3)
        );

        // Display queries
        System.out.println("Queries: " + queries);

        // Create solution object
        Solution obj = new Solution();

        // Get results for queries
        List<Integer> result = obj.maxXorQueries(arr, queries);

        // Display results
        System.out.println("Result of Max XOR Queries:");
        for (int i = 0; i < result.size(); ++i) {
            System.out.println("Query " + (i+1) + ": " + result.get(i));
        }
    }
}
