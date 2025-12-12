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
public class kthSmallest{
    // public static boolean find(TreeNode root,int[] count,int key,ArrayList<Integer>arr)
    // {
    //     if(root==null)
    //     {
    //         return false;
    //     }
    //     if(find(root.left,count,key,arr))return true;
    //     arr.add(root.val);
    //     count[0]+=1;
    //     if(count[0]==key)
    //     {
    //         return true;
    //     }
    //     return find(root.right,count,key,arr);

    // }
    public static void findsmall(TreeNode root,int[] count,int key,int[]result)
    {
        if(root==null || count[0]>=key)
        {
            return;
        }

        findsmall(root.left,count,key,result);

        count[0]++;
        if(count[0]==key)
        {
            result[0]=root.val;
            return;
        }

        findsmall(root.right,count,key,result);

    }
    public static int smallest(TreeNode root, int key)
    {
        int[] count=new int[1];
        // ArrayList<Integer>arr = new ArrayList<>();
        // find(root,count,key,arr);

        int[]result = new int[1];
        findsmall(root,count,key,result);
        System.out.println("result : "+result[0]);

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

        int k = 1;

        int ans = smallest(root,k);
        System.out.print(" ");
        System.out.println(ans);
    }
}