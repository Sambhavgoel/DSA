import java.util.*;
class Trie{
    Trie[] links;
    boolean flag;
    Trie()
    {
        links = new Trie[26];
        flag=false;
    }
    public boolean containsKey(char ch)
    {
        return links[ch-'a']!=null;
    }
    public Trie get(char ch)
    {
        return links[ch-'a'];
    }
    public void add(char ch, Trie node)
    {
        links[ch-'a'] = node;
    }
    public void setEnd()
    {
        flag = true;
    }
    public boolean isEnd()
    {
        return flag;
    }
}
class Node{
    private static Trie root;
    Node()
    {
        root = new Trie();
    }

    public void insert(String str)
    {
        Trie node = root;
        for(char ch : str.toCharArray())
        {
            if(!node.containsKey(ch))
            {
                node.add(ch,new Trie());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean exists(String str)
    {
        Trie node = root;
        for(char ch:str.toCharArray()) 
        {
            if(node.containsKey(ch))
            {
                node = node.get(ch);
                if(node.isEnd()==false)return false;

            }
            else{
                return false;
            }

        }
        return true;
    }


}
public class CompleteString {
    public static void main(String args[])
    {
        Node obj = new Node();
        List<String> nums = Arrays.asList(
        "n",
            "nin",
            "ninj",
            "ninja",
            "nil",
            "ni"
        );

        String ans  = "";

        for(int i=0;i<nums.size();i++)
        {
            obj.insert(nums.get(i));
        }

        for(int i=0;i<nums.size();i++)
        {
            if(obj.exists(nums.get(i)))
            {
                if(nums.get(i).length() > ans.length()){
                    ans = nums.get(i);
                }
                else if((nums.get(i).length() == ans.length())&&
                        (nums.get(i).compareTo(ans)<0))
                        {
                            ans = nums.get(i);
                        }
            }
        }

        System.out.println(ans);



    }
}
