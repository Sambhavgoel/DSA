class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val)
    {
        this.val=val;
    }
}

public class checkBST {

    public static boolean find(TreeNode root,int low, int high)
    {
        if(root==null)
        {
            return true;
        }

        if(root.val<=low || root.val>=high)
        {
            return false;
        }

        return find(root.left, low, root.val)&&find(root.right, root.val, high);
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

        int low = Integer.MIN_VALUE;
        int high  = Integer.MAX_VALUE;


        boolean ans = find(root,low,high);

        if(ans)
        {
            System.out.println("It's BST");
        }
        else{
            System.out.println("It's BT");
        }


    }
}
