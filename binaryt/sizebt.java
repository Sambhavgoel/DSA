class Node{
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key= k;
    }
}
class sizebt{
    public static void main(String args[])
    {
        Node root = new Node(65);
        root.left = new Node(563);
        root.right = new Node(45);
        root.left.right = new Node(652);
        root.left.left = new Node(87);

        int ans = size(root);
        System.out.println(ans);
    }
    public static int size(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
}