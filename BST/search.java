class Node{
    int key;
    Node left;
    Node right;
    Node(int k)
    {
        key = k;
    }
}
class search{
    public static void main(String args[])
    {
        Node root = new Node(65);
        root.left = new Node(54);
        root.right = new Node(68);
        root.left.left = new Node(52);
        root.right.right = new Node(102);
        root.left.right = new Node(60);

        boolean ans = number(root,60);
        System.out.println(ans);
    }
    public static boolean number(Node root , int k)
    {
        
        
        
        if(root==null)
        {
            return false;
        }
        else if(root.key == k)
        {
            return true;
        }
        else if(root.key<k)
        {
            return number(root.right,k);
        }
        else
        {
            return number(root.left,k);
        }
        
    }
}