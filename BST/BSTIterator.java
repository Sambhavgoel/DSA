import java.util.*;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val)
    {
        this.val = val;
    }
}
public class BSTIterator {
    private Stack<TreeNode>stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root)
    {
        pushAll(root);
    }
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
    public int next()
    {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    private void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
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

        BSTIterator iterate = new BSTIterator(root);

        System.out.println("HasNext() : "+ iterate.hasNext());
        System.out.println("Next() : " + iterate.next());
        System.out.println("HasNext() : "+ iterate.hasNext());
        System.out.println("Next() : " + iterate.next());

        System.out.println("HasNext() : "+ iterate.hasNext());
        System.out.println("Next() : " + iterate.next());
        System.out.println("HasNext() : "+ iterate.hasNext());
        System.out.println("Next() : " + iterate.next());
        System.out.println("HasNext() : "+ iterate.hasNext());
        System.out.println("Next() : " + iterate.next());
        System.out.println("HasNext() : "+ iterate.hasNext());
        System.out.println("Next() : " + iterate.next());
        System.out.println("HasNext() : "+ iterate.hasNext());
        System.out.println("Next() : " + iterate.next());
    }
}
