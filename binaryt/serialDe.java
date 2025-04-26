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
class serialDe{
    public static String serial(Node root)
    {
        if(root==null)
        {
            return "";
        }
        Queue<Node>q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            if(temp!=null)
            {
                sb.append(temp.data).append(",");
                q.offer(temp.left);
                q.offer(temp.right);
            }
            else{
                sb.append("#,");
            }
        }
        return sb.toString();
    }
    public static Node deserial(String data)
    {
        if(data.isEmpty())
        {
            return null;
        }

        StringBuilder s = new StringBuilder(data);

        int commaIndex = s.indexOf(",");
        String str = s.substring(0,commaIndex);
        s.delete(0,commaIndex+1);

        Node root = new Node(Integer.parseInt(str));

        Queue<Node>q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();

            commaIndex = s.indexOf(",");
            str = s.substring(0,commaIndex);
            s.delete(0,commaIndex+1);

            if(!str.equals("#"))
            {
                Node leftnode = new Node(Integer.parseInt(str));
                temp.left = leftnode;
                q.offer(leftnode);
            }

            commaIndex = s.indexOf(",");
            str = s.substring(0,commaIndex);
            s.delete(0,commaIndex+1);

            if(!str.equals("#"))
            {
                Node rightnode = new Node(Integer.parseInt(str));
                temp.right = rightnode;
                q.offer(rightnode);
            }

        }
        return root;



    }
    public static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String serialized = serial(root);
        System.out.println(serialized);
        Node temp = deserial(serialized);
        inorder(temp);

    }
}