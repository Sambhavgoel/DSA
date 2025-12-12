import java.util.*;
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class insertNode {
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
    public static void traverseLevel(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);


        while(!queue.isEmpty())
        {
                TreeNode curr = queue.poll();
                System.out.print(curr.val+" ");

                if(curr.left!=null)
                {
                    queue.add(curr.left);
                }
                if(curr.right!=null)
                {
                    queue.add(curr.right);
                }
        }

    }
    public static TreeNode insert(TreeNode root,int key) {
        if(root==null)
        {
            return new TreeNode(key);
        }
        TreeNode curr=root;
        while(true)
        {
            if(curr.val>key)
            {
                if(curr.left!=null)
                {
                    curr=curr.left;
                }
                else{
                    curr.left = new TreeNode(key);
                    break;
                }
            }
            else{
                if(curr.right!=null)
                {
                    curr= curr.right;
                }
                else{
                    curr.right = new TreeNode(key);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int key = 7;

        traverse(root);

        TreeNode ans = insert(root,key);
        System.out.println();
        traverse(ans);

    }
}
