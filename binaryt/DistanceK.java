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
class DistanceK{
    public static void distance(HashMap<Node,Node>map , Node root)
    {
        if(root==null)
        {
            return;
        }
        Queue<Node> q =new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            if(temp.left!=null)
            {
                map.put(temp.left,temp);
                q.offer(temp.left);
            }
            if(temp.right!=null)
            {
                map.put(temp.right,temp);
                q.offer(temp.right);
            }
        }

    }
    public static ArrayList<Integer>distancek(Node root,Node target,int k)
    {
        HashMap<Node,Node> map = new HashMap<>();
        distance(map,root);
        ArrayList<Integer>visited = new ArrayList<>();
        Queue<Node>queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target.data);
        int cur_level=0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            if(cur_level==k)
                {
                    break;
                }
                cur_level++;
            for(int i=0;i<size;i++)
            {
                Node temp = queue.poll();

                if(temp.left!=null && !visited.contains(temp.left.data))
                {
                    queue.offer(temp.left);
                    visited.add(temp.left.data);
                }

                if(temp.right!=null && !visited.contains(temp.right.data))
                {
                    queue.offer(temp.right);
                    visited.add(temp.right.data);
                }

                if(map.containsKey(temp) && !visited.contains(map.get(temp).data))
                {
                    queue.offer(map.get(temp));
                    visited.add(map.get(temp).data);
                }

            }
        }
        ArrayList<Integer>ans = new ArrayList<>();
        while(!queue.isEmpty())
        {
            ans.add(queue.poll().data);
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
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        
        Node target = root.left;
        int k = 3;
        
        ArrayList<Integer>res = distancek(root,target,k);
        for(int i=0;i<res.size();i++)
        {
            System.out.print(res.get(i)+" ");
        }
        


    }
}