class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val)
    {
        this.val=val;
    }
}

public class LCA {

    public static TreeNode find(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
        {
            return null;
        }
        int curr = root.val;
        if(curr<p.val && curr<q.val)
        {
            return find(root.right,p,q);
        }
        if(curr>p.val && curr>q.val)
        {
            return find(root.left,p,q);
        }
        return root;
    }
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        TreeNode p = root.right.left;
        TreeNode q = root.right.right;


        TreeNode ans = find(root,p,q);
        System.out.println(ans.val);
    }
}
