class Trie{
    private Trie[]links;
    Trie()
    {
        links = new Trie[2];
    }
    public boolean containsKey(int bit)
    {
        return links[bit]!=null;
    }
    public Trie get(int bit)
    {
        return links[bit];
    }
    public void add(int bit, Trie node)
    {
        links[bit] = node;
        return;
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
                node.add(bit,new Trie());
            }
            node = node.get(bit);
        }
    }
    public int getMax(int num)
    {
        Trie node = root;
        int ans = 0;
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
    public int findMaximumXOR(int[]nums)
    {
        Node node = new Node();
        for(int ele : nums)
        {
            node.insert(ele);
        }
        int max =0 ;
        for(int ele : nums)
        {
            max = Math.max(max,node.getMax(ele));
        }
        return max;
    }
}
// Driver code
public class XorTwoNum {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        Solution sol = new Solution();
        System.out.println(sol.findMaximumXOR(nums));
    }
}
