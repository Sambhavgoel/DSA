class Node {
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class height{
    public static void main(String args[])
    {
        Node root = new Node(64);
        root.left = new Node(54);
        root.right = new Node(7);
        root.left.left = new Node(15);
        root.left.left.left = new Node(55);
        int ans = hgt(root);
        System.out.println("Height of tree is : "+ans);
    }
    public static int hgt(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        return Math.max(hgt(root.left) , hgt(root.right))+1;
    }
}