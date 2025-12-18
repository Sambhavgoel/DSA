import java.util.*;
class Node{
    private Node[] links;
    private int prefix;
    private int end;

    Node(){
        links = new Node[26];
        prefix=0;
        end=0;
    }

    public boolean containsKey(char ch)
    {
        return (links[ch-'a']!=null);
    }
    public Node get(char ch)
    {
        return links[ch-'a'];
    }
    public void add(char ch , Node node)
    {
        links[ch-'a'] = node;
        return;
    }
    public void incPrefix()
    {
        prefix++;
        return;
    }
    public void incEnd()
    {
        end++;
        return;
    }
    public int getEnd()
    {
        return end;
    }
    public int getPrefix()
    {
        return prefix;
    }
    public void decPrefix()
    {
        prefix--;
    }
    public void decEnd()
    {
        end--;
    }




}
// Trie class
class PrefixTrie {
 private Node root;
    /* Constructor to initialize the
    Trie with an empty root node */
    public PrefixTrie() {
        root = new Node();
    }

    /* Inserts a word into the Trie
    Time Complexity O(len), where len
    is the length of the word */
    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray())
        {
            if(!node.containsKey(ch))
            {
                node.add(ch,new Node());
            }

            node = node.get(ch);
            node.incPrefix();
        }
        node.incEnd();

    }

    /* Returns the number of words
    equal to a given word */
    public int countWordsEqualTo(String word) {
        Node node = root;
        for(char ch : word.toCharArray())
        {
            if(node.containsKey(ch))
            {
                node = node.get(ch);
            }
            else{
                return 0;
            }
        }
        return node.getEnd();
        
    }

    /* Returns the number of words
    starting with a given prefix */
    public int countWordsStartingWith(String word) {
        Node node = root;
        for(char ch : word.toCharArray())
        {
            if(node.containsKey(ch))
            {
                node = node.get(ch);
            }
            else{
                return 0;
            }
        }
        return node.getPrefix();
    }

    /* Erases a word from the Trie */
    public void erase(String word) {
        Node node = root ;
        for(char ch : word.toCharArray())
        {
            if(node.containsKey(ch))
            {
                node = node.get(ch);
                node.decPrefix();
            }
            else {
                return;
            }
        }
        node.decEnd();
    }

    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();
        trie.insert("apple");
        trie.insert("apple");
        System.out.println("Inserting strings 'apple' twice into Trie");
        System.out.println("Count Words Equal to 'apple': " + trie.countWordsEqualTo("apple"));
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'apple' from Trie");
        trie.erase("apple");
        System.out.println("Count Words Equal to 'apple': " + trie.countWordsEqualTo("apple"));
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'apple' from Trie");
        trie.erase("apple");
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
    }
}