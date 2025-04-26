class Node{
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class levelordernaive{
    public static void main(String args[])
    {
        Node root = new Node(64);
        root.left = new Node(45);
        root.right = new Node(91);
        root.left.left = new Node(62);
        root.right.right = new Node(84);
        root.right.right.left = new Node(874);

        int n = height(root);
        for(int i=0;i<n;i++)
        {
            System.out.println("Nodes at the level "+i+" is : ");
            allnodes(root , i);
            
        }
    }
    public static int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;

    }
    public static void allnodes(Node root , int k)
    {
        if(root == null)
        {
            return;
        }
        if(k==0)
        {
            System.out.println(root.key+" ");
        }
        else{
            allnodes(root.left,k-1);
            allnodes(root.right,k-1);

        }
    }
}