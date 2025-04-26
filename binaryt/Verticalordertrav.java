import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Verticalordertrav {

    static class Triplet {
        Node node;
        int row;
        int col;

        Triplet(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static List<List<Integer>> vertical(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(root, 0, 0));

        while (!queue.isEmpty()) {
            Triplet t = queue.poll();
            Node node = t.node;
            int row = t.row;
            int col = t.col;

            // Insert into TreeMap
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.data);

            // Left and right children
            if (node.left != null) {  // Fixed (was root.left)
                queue.offer(new Triplet(node.left, row + 1, col - 1));
            }
            if (node.right != null) {  // Fixed (was root.right)
                queue.offer(new Triplet(node.right, row + 1, col + 1));
            }
        }

        // Build the result list
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> columnNodes = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) { // Fixed (was row.values())
                while (!pq.isEmpty()) {
                    columnNodes.add(pq.poll());
                }
            }
            result.add(columnNodes);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(vertical(root));
    }
}
