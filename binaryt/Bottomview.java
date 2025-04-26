import java.util.*;
class Node{
    int data;
    Node right;
    Node left;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}
class Bottomview{
    static class Double
    {
        int col;
        Node node;
        Double(int col,Node node)
        {
            this.col=col;
            this.node=node;
        }
    }
    public static List<Integer> bottom(Node root)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        TreeMap<Integer,Integer>map = new TreeMap<>();
        Queue<Double>queue = new LinkedList<>();

        queue.offer(new Double(0,root));

        while(!queue.isEmpty())
        {
            Double d = queue.poll();
            int col = d.col;
            Node node = d.node;

            map.put(col,node.data);

            if(node.left!=null)
            {
                queue.offer(new Double(col-1,node.left));
            }
            if(node.right!=null)
            {
                queue.offer(new Double(col+1,node.right));
            }
        }

        return new ArrayList<>(map.values());

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

        System.out.println(bottom(root));
    }
}