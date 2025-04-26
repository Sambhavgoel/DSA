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
class Widthofbt{
    static class Doublet{
        int id;
        Node node;
        Doublet(int id , Node node)
        {
            this.id = id;
            this.node=node;

        }
    }
    public static int width(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        Queue<Doublet>queue = new LinkedList<>();
        queue.offer(new Doublet(0,root));
        int ans=0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int min = queue.peek().id;
            int first=0;
            int last=0;

            for(int i=0;i<size;i++)
            {
                int curid = queue.peek().id-min;
                Node temp = queue.peek().node;
                queue.poll();

                if(i==0)
                {
                    first = curid;
                }
                if(i==size-1)
                {
                    last = curid;
                }
                if(temp.left!=null)
                {
                    queue.offer(new Doublet(2*curid+1,temp.left));
                }
                if(temp.right!=null)
                {
                    queue.offer(new Doublet(2*curid+2,temp.right));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
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

        System.out.println(width(root));
    }
}