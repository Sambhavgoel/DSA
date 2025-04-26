class Node{
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class preordertrave{
    public static void main(String args[])
    {
        Node root = new Node(54);
        root.left = new Node(5);
        root.right = new Node(75);
        root.left.left = new Node(59);
        preorder(root);
    }
    public static void preorder(Node root)
    {
        if(root!=null)
        {
            System.out.println(root.key);
            preorder(root.left);
            preorder(root.right);
        }
    }
}