class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val)
    {
        this.val= val;
    }
}
public class constructfromPreorder {
    public static TreeNode construct(int[]A,int bound, int[]i)
    {
        if(i[0]==A.length || A[i[0]]>bound)return null;

        TreeNode root = new TreeNode(A[i[0]++]);

        root.left = construct(A, root.val, i);
        root.right = construct(A,bound,i);

        return root;

    }
    public static TreeNode constructBST(int[]A)
    {
        int[] i = new int[]{0};
        int bound = Integer.MAX_VALUE;
        return construct(A,bound,i);

    }
    public static void main(String args[])
    {
        int[]A = {8,5,1,7,10,12};
        TreeNode root = constructBST(A);
        traverse(root);

    }

    public static void traverse(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        traverse(root.left);
        System.out.print(root.val+" ");
        traverse(root.right);
    }
}
