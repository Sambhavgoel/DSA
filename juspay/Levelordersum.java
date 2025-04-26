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
class Levelordersum{
    public static Node buildtree(int[]arr)
    {

        if(arr.length==0)
        {
            return null;
        }
        Queue<Node>queue = new LinkedList<>();
        Node root = new Node(arr[0]);
        queue.add(root);
        int i=1;

        while(i<arr.length)
        {
            Node current = queue.poll();

            if(i<arr.length)
            {
                current.left = new Node(arr[i++]);
                queue.offer(current.left);
            }
            if(i<arr.length)
            {
                current.right = new Node(arr[i++]);
                queue.offer(current.right);
            }
        }
        return root;

    }

    public static int sum(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            return root.data;
        }
        
        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        if(leftsum==-1 || rightsum==-1)
        {
            return -1;
        }
        if(root.data!=(leftsum+rightsum))
        {
            return -1;
        }
        
        return root.data+leftsum+rightsum;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        Node root = buildtree(arr);
        int finalsum = sum(root);
        if(finalsum==-1)
        {
            System.out.println("NOT a sumtree");
        }
        else{
            System.out.println("It is a sumtree");
        }

    }
}