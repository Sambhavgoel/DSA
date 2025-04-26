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
class burnNode{
    public static void distance(Node root,HashMap<Node,Node>map)
    {
        if(root==null)
        {
            return;
        }
        Queue<Node>q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            if(temp.left!=null)
            {
                q.offer(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null)
            {
                q.offer(temp.right);
                map.put(temp.right,temp);
            }
        }
    }
    public static void burnTime(Node root,Node target)
    {
        HashMap<Node,Node>map = new HashMap<>();
        distance(root,map);
        Queue<Node>q = new LinkedList<>();
        HashMap<Node,Boolean>visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int time=0;
        while(!q.isEmpty())
        {
            
            // time++;
            boolean burn=false;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                
                Node temp = q.poll();
                if(temp.left!=null && visited.get(temp.left)==null)
                {
                    q.offer(temp.left);
                    visited.put(temp.left,true);
                    burn=true;
                }
                if(temp.right!=null && visited.get(temp.right)==null)
                {
                    q.offer(temp.right);
                    visited.put(temp.right,true);
                    burn=true;
                }

                if(map.get(temp)!=null && visited.get(map.get(temp))==null)
                {
                    q.offer(map.get(temp));
                    visited.put(map.get(temp),true);
                    burn=true;
                }
                
            }
            if(burn)
                {
                    time++;
                }
        }
        System.out.println("Time taken  : "+time);

    }
    public static void main(String args[])
    {
        Node root = new  Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);

        Node target = root.left;

        burnTime(root,target);
    }
}