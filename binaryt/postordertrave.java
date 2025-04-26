class Node{
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class postordertrave{
    public static void main(String args[])
    {
        Node root = new Node(54);
        root.left = new Node(5);
        root.right = new Node(75);
        root.left.left = new Node(59);
        postorder(root);
    }
    public static void postorder(Node root)
    {
        if(root!=null)
        {
            
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.key);
        }
    }
}