import java.util.*;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val)
    {
        this.val=val;
    }
}
// in inorder with bst, it always have the elements in sorted order
public class kthLargest{

    public static void findlarge(TreeNode root,int[] count,int key,int[]result)
    {
        if(root==null || count[0]>=key)
        {
            return;
        }
        findlarge(root.right, count, key, result);   // here we move to right side first
        count[0]++;
        if(count[0]==key)
        {
            result[0]=root.val;
            return;
        }

        findlarge(root.left, count, key, result);



    }
    public static int largest(TreeNode root, int key)
    {
        int[]count = new int[1];
        int[]result = new int[1];
        findlarge(root, count, key, result);
        return result[0];
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

        int k = 2;

        int ans = largest(root,k);
        System.out.println(ans);
    }
}