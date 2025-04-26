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
class flattenBT{
    public static void flatten(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            if(temp.left!=null)
            {
                Node cur = temp.left;

                while(cur.right!=null)
                {
                    cur=cur.right;
                }
                cur.right = temp.right;
                temp.right=temp.left;
                temp.left=null;
            }
            temp=temp.right;
        }
    }
    public static void preorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right = new Node(7);
        root.right.left = new Node(8);

        flatten(root);
        preorder(root);
    }
}