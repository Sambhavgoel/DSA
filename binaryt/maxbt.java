class Node{
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key= k;
    }
}
class maxbt{
    public static void main(String args[])
    {
        Node root = new Node(65);
        root.left = new Node(563);
        root.right = new Node(1000);
        root.left.right = new Node(652);
        root.left.left = new Node(87);

        int ans = max(root);
        System.out.println(ans);
    }
    public static int max(Node root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.key,Math.max(max(root.left),max(root.right)));
    }
}