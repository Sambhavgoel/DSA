import java.util.*;
class TreeNode{
    TreeNode right;
    TreeNode left;
    int val;
    TreeNode(int val)
    {
        this.val=val;
    }
}
class BSTiterator{
    private Stack<TreeNode>stack = new Stack<>();
    boolean reverse;
    public BSTiterator(TreeNode root, boolean reverse)
    {
        this.reverse=reverse;
        pushAll(root,reverse);

    }
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
    public int next()
    {
        TreeNode temp = stack.pop();
        if(reverse)
        {
            pushAll(temp.left,reverse);
        }
        else{
            pushAll(temp.right, reverse);
        }
        return temp.val;
    }
    public void pushAll(TreeNode root,boolean reverse)
    {
        if(reverse==false)
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
        }
        else{
            while(root!=null)
            {
                stack.push(root);
                root=root.right;
            }
        }
    }
}
public class TwoSum {


    public static void main(String args[])
    {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        int k=7;

        BSTiterator iterate1 = new BSTiterator(root, false);
        BSTiterator iterate2 = new BSTiterator(root,true);

        int i = iterate1.next();
        int j = iterate2.next();

        while(i<j)
        {
            if((i+j)==k)
            {
                System.out.println("Exits");
                return;
            }
            else if((i+j)>k){
                if(iterate2.hasNext())
                {
                    j=iterate2.next();
                }
                else{
                    break;
                }
            }
            else if((i+j<k))
            {
                if(iterate1.hasNext())
                {
                    i=iterate1.next();
                }
                else{
                    break;
                }
            }

        }

        System.out.println("Not Exists");



    }
}
