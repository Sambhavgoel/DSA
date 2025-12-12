class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

public class search {
    public static TreeNode searchNode(TreeNode root, int key) {
        while (root != null && root.val != key) {
            root = root.val > key ? root.left : root.right;
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

        int key = 4;

        TreeNode ans = searchNode(root, key);

        if (ans != null) {
            System.out.println("Key is found");
        } else {
            System.out.println("Key is not found");

        }

    }
}
