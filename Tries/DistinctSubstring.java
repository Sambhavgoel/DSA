import java.util.*;

class Node {
    Node[] links;

    Node()
    {
        links = new Node[26];
    }

    public boolean containsKey(char ch)
    {
        return links[ch-'a']!=null;
    }

    public void add(char ch,Node node)
    {
        links[ch-'a']=node;
    }
    public Node get(char ch)
    {
        return links[ch-'a'];
    }

}
class Trie{
    private Node root;
    Trie()
    {
        root = new Node();
    }

    public void insert(String str)
    {
        Node node  = root;
        for(char ch : str.toCharArray())
        {
            if(!node.containsKey(ch))
            {
                node.add(ch,new Node());
            }
            node= node.get(ch);
        }
    }

    public boolean exists(String str)
    {
        Node node = root;
        for(char ch : str.toCharArray())
        {
            if(!node.containsKey(ch))
            {
                return false;
            }
            node =node.get(ch);
        }

        return true;
    }

}


class Solution {

    public int countDistinctSubstrings(String s) {
        int ans = 0;
        int n = s.length();

        Node root = new Node();

        for(int i=0;i<n;i++)
        {
            Node node = root;
            for(int j=i;j<n;j++)
            {
                if(!node.containsKey(s.charAt(j)))
                {
                    ans+=1;
                    node.add(s.charAt(j),new Node());
                }
                node = node.get(s.charAt(j));
            }
        }
        return ans+1;

    }
}

public class DistinctSubstring {
    public static void main(String[] args) {
        String s = "striver";
        System.out.println("Current String: " + s);

        Solution sol = new Solution();
        // Input string
        System.out.println("Number of distinct substrings: " + sol.countDistinctSubstrings(s));
    }
}
