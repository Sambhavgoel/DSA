class Node{
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class inordertrave{
    public static void main(String args[])
    {
        Node root = new Node(56);
        root.left = new Node(58);
        root.right = new Node(8);
        root.left.left = new Node(52);
        inorder(root);
    }
    public static void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }
}