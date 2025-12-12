
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class maxSearch {
    public static int searchNode(TreeNode root) {
        if(root==null)
        {
            return -1;
        }
        if(root.right==null)
        {
            return root.val;
        }
        else{
            return searchNode(root.right);
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int ans = searchNode(root);

        System.out.println(ans);

    }
}
