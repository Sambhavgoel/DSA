import java.util.*;
public class BuildPreOrder{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
            this.right = null;
            this.left=null;
        }
    }

    static class BinaryTree{
        static int i=-1;
        public static Node buildTree(int nodes[])
        {   i++;
            if(i>=nodes.length || nodes[i] == -1 )
            {
                return null;
            }

            Node root = new Node(nodes[i]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }
        public static void printPreOrder(Node root){

            if(root == null)
            {
               
                return;
            }
            System.out.print(root.data+" ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }

        public static void printInOrder(Node root){

            if(root == null)
            {
               
                return;
            }
            printInOrder(root.left);
            System.out.print(root.data+" ");
            printInOrder(root.right);
        }
        public static void printPostOrder(Node root){

            if(root == null)
            {
                return;
            }
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes you want to enter : ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Enter the nodes : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);
        System.out.println("PreOrder Traversal");
        tree.printPreOrder(root);
        System.out.println("\n"+"InOrder Traversal");
        tree.printInOrder(root);
        System.out.println("\n"+"PostOrder Traversal");
        tree.printPostOrder(root);


    }
}