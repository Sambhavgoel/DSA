
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class floor {  // we want min but greater than key
    public static int findFloor(TreeNode root,int key) {
        int floor = Integer.MAX_VALUE;

        if(root==null)
        {
            return -1;
        }

        while(root!=null)
        {
            if(key==root.val)
            {
                return root.val;
            }
            else if(root.val>key)
            {
                root = root.left;
            }
            else{
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int key=7;

        int ans = findFloor(root,key);

        if(ans!=Integer.MAX_VALUE)
        {
            System.out.println(ans);
        }
        else{
            System.out.println("Tree doesn't exists");

        }

    }
}
