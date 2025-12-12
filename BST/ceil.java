
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ceil {  // we want min but greater than key
    public static int findCeil(TreeNode root,int key) {
        int ceil=-1;
        if(root==null)
        {
            return ceil;
        }

        while(root!=null)
        {
            if(root.val==key)
            {
                ceil=root.val;
                return ceil;
            }
            
            if(root.val<key)       // key bdi ho gyi aur data chota reh gya toh aur bde pr bhej diya h
            {
                root = root.right;
            }
            else{                       // bda mil gya
                ceil = root.val;
                root=root.left;  // bde m chota dhoond rhe h
            }
        }
        return ceil;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int key=8;

        int ans = findCeil(root,key);

        if(ans!=-1)
        {
            System.out.println(ans);
        }
        else{
            System.out.println("Tree doesn't exists");

        }

    }
}
