import java.util.*;

class Bfs {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTreeLevelOrder(int[] nodes) {
        if (nodes.length == 0) {
            return null;
        }

        Node root = new Node(nodes[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            Node current = queue.poll();

            // Add left child
            if (i < nodes.length && nodes[i] != -1) {
                current.left = new Node(nodes[i]);
                queue.add(current.left);
            }
            i++;

            // Add right child
            if (i < nodes.length && nodes[i] != -1) {
                current.right = new Node(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);  // Level separator

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            if (currNode == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes you want to enter (use -1 for null nodes): ");
        int n = sc.nextInt();

        System.out.println("Enter the nodes: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTreeLevelOrder(arr);
        System.out.println("Level Order Traversal:");
        levelOrderTraversal(root);
    }
}
