class Node {
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class nodeatk{
    public static void main(String args[])
    {
        Node root = new Node(64);
        root.left = new Node(54);
        root.right = new Node(7);
        root.left.left = new Node(15);
        root.left.left.left = new Node(55);
        distance(root,2);
        
    }
    public static void distance(Node root,int k)
    {
        if(root==null)
        {
            return ;
        }
        if(k==0)
        {
            System.out.println(root.key+" ");
        }
        else{
            distance(root.left,k-1);
            distance(root.right,k-1);
        }
    }
}