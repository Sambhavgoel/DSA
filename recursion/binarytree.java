import java.util.*;
class Node{
    int key;
    Node left;
    Node right;
    Node(int k){
        key=k;
    }
}
class binarytree{
    public static void traverse(Node root){
        if(root!=null)
        {
            System.out.println(root.key);
            traverse(root.left);
            traverse(root.right);
        }
        return;
        
        
    }
    public static int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(34);
        root.left = new Node(56);
        root.right = new Node(65);
        root.left.left = new Node(74);
        root.right.right = new Node(5);
        root.left.left.left = new Node(66);
        traverse(root);
        int num = height(root);
        System.out.println("Height of binary tree is : "+num);
    }
}