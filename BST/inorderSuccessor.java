
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class inorderSuccessor {  // we want min but greater than key

    public static TreeNode find(TreeNode root,TreeNode key)
    {
        TreeNode successor = null;

        while(root!=null)
        {
            if(root.val>key.val)
            {
                successor=root;
                root = root.left;
            }
            else{
                root = (root.right);
            }
        }
        return successor;


    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        TreeNode key=root.left.left;
        
        TreeNode ans = find(root,key);
        System.out.println(ans.val);



    }
}
