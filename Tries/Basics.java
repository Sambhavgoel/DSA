import java.util.*;

class Node {
    /* Array to store links to child nodes,
    each index represents a letter */
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch)
    {
        return (links[ch-'a']!=null);
    }
    void add(char ch, Node node)
    {
        links[ch-'a'] = node;
        return;
    }
    Node get(char ch)
    {
        return links[ch-'a'];
    }

    void setEnd()
    {
        flag =true;
    }

    boolean isEnd(){
        return flag;
    }



    
}

// Trie class
class Trie {
    private Node root;

    /* Inserts a word into the Trie
    Time Complexity O(len), where len
    is the length of the word */

    public Trie()
    {
        root = new Node();
    }


    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char wrd = word.charAt(i);
            if(!node.containsKey(wrd))
            {
                node.add(wrd,new Node());
            }
            node=node.get(wrd);
        }
        node.setEnd();
    }

    /* Returns if the word
    is in the trie */
    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++)
        {
            char wrd = word.charAt(i);
            if(!node.containsKey(wrd))return false;
            node=node.get(wrd);
        }
        return node.isEnd();
    }

    /* Returns if there is any word in the
    trie that starts with the given prefix */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++)
        {
            char wrd = prefix.charAt(i);
            if(!node.containsKey(wrd))return false;
            node=node.get(wrd);
        }
        return true;
        
    }
}

class Basics {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] operations = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[][] arguments = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};

        List<String> output = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Trie":
                    output.add("null");
                    break;
                case "insert":
                    trie.insert(arguments[i][0]);
                    output.add("null");
                    break;
                case "search":
                    output.add(trie.search(arguments[i][0]) ? "true" : "false");
                    break;
                case "startsWith":
                    output.add(trie.startsWith(arguments[i][0]) ? "true" : "false");
                    break;
            }
        }

        for (String res : output) {
            System.out.println(res);
        }
    }
}