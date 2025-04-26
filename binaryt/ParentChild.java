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
class ParentChild
{
    public static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void solution(Node root)
    {
        if(root==null)
        {
            return ;
        }
        int child=0;

        if(root.left!=null)
        {
            child +=root.left.data;
        }
        if(root.right!=null)
        {
            child+=root.right.data;
        }

        if(child>=root.data)
        {
            root.data=child;
        }
        else{
            if(root.left!=null)
            {
                root.left.data = root.data;
            }
            if(root.right!=null)
            {
                root.left.data = root.data;
            }
        }

        solution(root.left);
        solution(root.right);

        int tot=0;
        if(root.left!=null)
        {
            tot += root.left.data;
        }
        if(root.right!=null)
        {
            tot += root.right.data;
        }
        if(root.left!=null || root.right!=null)
        {
            root.data=tot;
        }



    }
    public static void main(String args[])
    {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println("Before relatiopnship : ");
        inorder(root);
        solution(root);
        System.out.println("");
        System.out.println("After relatiopnship : ");
        inorder(root);
    }
}