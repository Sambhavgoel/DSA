import java.util.*;
class Node {
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class levelorder{
    public static void main(String args[])
    {
        Node root = new Node(65);
        root.left = new Node(56);
        root.right = new Node(54);
        root.left.left = new Node(86);
        root.right.right = new Node(32);
        root.left.right = new Node(35);

        lotraverse(root);
    }
    public static void lotraverse(Node root)
    {
        if(root==null)
        {
            System.out.println("There is no  node in the tree");
            return;
        }

        Queue<Node> q  = new LinkedList<Node>();

        q.add(root);
        while(q.isEmpty()==false)
        {
            Node curr = q.poll();
            System.out.println(curr.key);

            if(curr.left!=null)
            {
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
            }
        }
    }
}