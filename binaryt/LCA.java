class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
class LCA{
    public static Node solve(Node root, int p , int q)
    {
        if(root==null)
        {
            return null;
        }
        if(root.data==p || root.data==q)
        {
            return root;
        }
        Node left = solve(root.left,p,q);
        Node right = solve(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }
        return (left!=null)?left:right;


    }

    public static void main(String args[])
    {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right= new Node(1);
        root.left.left =  new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right= new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right= new Node(4);


        int p=7;
        int q=6;
        Node ans = solve(root,p,q);
        System.out.println(ans.data);


    }

}