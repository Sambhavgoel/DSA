import java.util.*;

class Node{
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
class morrisIn{
    public static ArrayList<Integer> inorder(Node root,ArrayList<Integer>ans)
    {
        if(root==null)
        {return ans;}

        Node temp = root;
        while(temp!=null)
        {
            if(temp.left==null)
            {
                ans.add(temp.data);
                temp  = temp.right;
            }
            else{
                Node prev = temp.left;
                while(prev.right!=null && prev.right!=temp)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=temp;
                    temp=temp.left;
                }
                else{
                    prev.right=null;
                    ans.add(temp.data);
                    temp=temp.right;
                }

                
            }
            
        }
        return ans;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        ArrayList<Integer> ans  = new ArrayList<>();
        inorder(root,ans);
        for(int i : ans)
        {
            System.out.println(i);
        }
    }
}