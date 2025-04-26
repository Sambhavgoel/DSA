import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}
class Inpostorder{
    public static Node buildTree(ArrayList<Integer>inorder,ArrayList<Integer>postorder)
    {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<inorder.size();i++)
        {
            map.put(inorder.get(i),i);
        }
        Node root = build(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1,map);
        return root;
    }
    public static Node build(ArrayList<Integer>inorder,int instart,int inend,ArrayList<Integer>postorder,int poststart,int postend,HashMap<Integer,Integer>map)
    {
        if(poststart>postend || instart>inend)
        {
            return null;
        }
        int inplace = map.get(postorder.get(postend));
        int left = inplace-instart;

        Node root = new Node(postorder.get(postend));
        root.left = build(inorder,instart,inplace-1,postorder,poststart,poststart+left-1,map);
        root.right = build(inorder,inplace+1,inend,postorder,poststart+left,postend-1,map);
        return root;
    }
    public static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static void main(String args[])
    {
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(40, 20, 50, 10, 60, 30));
        ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(40, 50, 20, 60, 30, 10));

        
        Node root = buildTree(inorder,postorder);
        inorder(root);
    }
}