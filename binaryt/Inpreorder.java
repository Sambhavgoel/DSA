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
class Inpreorder{
    public static Node buildTree(ArrayList<Integer>inorder,ArrayList<Integer>preorder)
    {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<inorder.size();i++)
        {
            map.put(inorder.get(i),i);
        }

        Node root = build(preorder,0,preorder.size()- 1,inorder,0,inorder.size()-1,map);

        return root;
    }
    public static Node build(ArrayList<Integer>preorder,int prestart,int preend,ArrayList<Integer>inorder,int instart,int inend,HashMap<Integer,Integer>map)
    {
        if(prestart>preend || instart>inend)
        {
            return null;
        }
        Node root = new Node(preorder.get(prestart));

        int inroot = map.get(root.data);
        int left   = inroot-instart;

        root.left  = build(preorder,prestart+1,prestart+left,inorder,instart,inroot-1,map);
        root.right = build(preorder,prestart+left+1,preend,inorder,inroot+1,inend,map);
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
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(9, 3, 15, 20, 7));
        ArrayList<Integer> preorder = new ArrayList<>(Arrays.asList(3, 9, 20, 15, 7));

        Node root = buildTree(inorder,preorder);
        inorder(root);

    }
}