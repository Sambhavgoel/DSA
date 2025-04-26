import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data =data;
        left=null;
        right=null;
    }
}
class countNode{
    public static int solution(Node root)
    {
        int lh = leftheight(root);
        int rh = rightheight(root);
        if(lh==rh)
        {
            return (int)Math.pow(2,lh)-1;
        }
        else{
            return 1+solution(root.left)+solution(root.right);
        }
    }
    public static int rightheight(Node root)
    {
        int count=0;
        while(root!=null)
        {
            count++;
            root = root.right;
        }
        return count;
    }

    public static int leftheight(Node root)
    {
        int count=0;
        while(root!=null)
        {
            count++;
            root = root.left;
        }
        return count;
    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        int height = solution(root);
        System.out.println(height);

    }
}