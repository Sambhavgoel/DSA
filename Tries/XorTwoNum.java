// Trie node definition
class Node {
    Node[] links = new Node[2];

    // Check if bit path exists
    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    // Get child node for the bit
    public Node get(int bit) {
        return links[bit];
    }

    // Set child node for the bit
    public void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Solution {
    Node root = new Node();

    // Insert number into the Trie
    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            // Get the i-th bit
            int bit = (num >> i) & 1;

            // Create path if not present
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            // Move to next node
            node = node.get(bit);
        }
    }

    // Get max XOR for a given number
    public int getMaxXOR(int num) {
        Node node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            // Get the i-th bit
            int bit = (num >> i) & 1;

            // Try opposite bit for max XOR
            if (node.containsKey(1 - bit)) {
                maxXor |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxXor;
    }

    // Find max XOR among all pairs
    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }

        int maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, getMaxXOR(num));
        }

        return maxResult;
    }
}

// Driver code
public class XorTwoNum {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        Solution sol = new Solution();
        System.out.println(sol.findMaximumXOR(nums));
    }
}
