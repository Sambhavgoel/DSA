import java.util.*;
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class deleteNode {
    public static void traverse(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        traverse(root.left);
        System.out.print(root.val+" ");
        traverse(root.right);
    }

    public static TreeNode delete(TreeNode root, int key)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==key)
        {
            return helper(root);
        }

        TreeNode dummy = root;

        while(root!=null)
        {
            if(root.val>key)
            {
                if(root.left!=null && root.left.val==key)
                {
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val==key)
                {
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    
    public static TreeNode helper(TreeNode root)
    {
        if(root.left==null)
        {
            return root.right;
        }
        else if(root.right==null)
        {
            return root.left;
        }
        else{
            TreeNode rightSubtree  = root.right;
            TreeNode leftRightOne = findRight(root.left);
            leftRightOne.right = rightSubtree;
            return root.left;
        }
    }
    public static TreeNode findRight(TreeNode root)
    {
        if(root.right==null)
        {
            return root;
        }
        return findRight(root.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int key = 10;

        traverse(root);

        TreeNode ans = delete(root,key);
        System.out.println();
        traverse(ans);

    }
}
