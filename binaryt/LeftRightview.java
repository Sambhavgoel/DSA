import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class LeftRightview{
    public static void leftview(Node root,int levelleft,ArrayList<Integer>left)
    {
        if(root==null)
        {
            return;
        }

        if(left.size()==levelleft)
        {
            left.add(root.data);
        }

        leftview(root.left,levelleft+1,left);
        leftview(root.right,levelleft+1,left);

        return;

    }

    public static void rightview(Node root,int levelright,ArrayList<Integer>right)
    {
        if(root==null)
        {
            return;
        }

        if(right.size()==levelright)
        {
            right.add(root.data);
        }

        rightview(root.right,levelright+1,right);
        rightview(root.left,levelright+1,right);

        return;
    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        int levelleft=0;
        ArrayList<Integer>left = new ArrayList<>();

        int levelright=0;
        ArrayList<Integer>right = new ArrayList<>();

        leftview(root,levelleft,left);
        rightview(root,levelright,right);

        System.out.println(left);
        System.out.println(right);
    }
}