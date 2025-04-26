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
class Verticalorder{
    static class Triplet{
        int row;
        int col;
        Node node;
        Triplet(int col,int row,Node node)
        {
            this.col=col;
            this.row=row;
            this.node = node;
        }
    }
    public static List<List<Integer>> vertical(Node root)
    {
        if(root==null)
        {
            return null;
        }
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map = new TreeMap<>();
        Queue<Triplet>queue = new LinkedList<>();
        queue.offer(new Triplet(0,0,root));

        while(!queue.isEmpty())
        {
            Triplet t = queue.poll();
            Node node = t.node;
            int row = t.row;
            int col = t.col;

            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).offer(node.data);

            if(node.left!=null)
            {
                queue.offer(new Triplet(col-1,row+1,node.left));
            }
            if(node.right!=null)
            {
                queue.offer(new Triplet(col+1,row+1,node.right));
            }
        }
        List<List<Integer>>res= new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>row : map.values())
        {
            List<Integer> ans = new ArrayList<>();
            for(PriorityQueue<Integer>pq : row.values())
            {
                while(!pq.isEmpty())
                {
                    ans.add(pq.poll());
                }
            }
            res.add(ans);
        }
        return res;
    }
    public static void main(String args[])
    {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(vertical(root));

    }

}