import java.util.*;
class Node {
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
}
}
class morrisPre{
    public static void preorder(Node root,ArrayList<Integer>ans)
    {
        if(root==null)
        {
            return ;
        }
        Node temp = root;
        while(temp!=null)
        {
            if(temp.left==null)
            {
                ans.add(temp.data);
                temp=temp.right;
            }
            else{
                Node pre = temp.left;
                while(pre.right!=null && pre.right!=temp)
                {
                    pre=pre.right;
                }
                if(pre.right==null)
                {
                    pre.right=temp;
                   
                    temp=temp.left;
                }
                else{
                    pre.right=null;
                    ans.add(temp.data);
                    temp=temp.right;

                }
            }
        }
        // return ans;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        ArrayList<Integer>ans = new ArrayList<>();
        preorder(root,ans);
        for(int i : ans)
        {
            System.out.println(i);
        }
    }
}