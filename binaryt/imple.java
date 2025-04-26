class Node{
    int key;
    Node left;
    Node right;
    Node(int k )
    {
        key = k;
    }
}
class imple{
    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(51);
        root.left.left = new Node(40);

        // Node root = null;
    }
}