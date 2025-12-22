import java.util.*;

// Structure for a trie node
class Node {
    // Array to hold links to child nodes (0 and 1)
    Node[] links = new Node[2];

    // Function to check if a child node exists for a given bit
    boolean containsKey(int ind) {
        return links[ind] != null;
    }

    // Function to get the child node for a given bit
    Node get(int ind) {
        return links[ind];
    }

    // Function to create a link to a child node for a given bit
    void put(int ind, Node node) {
        links[ind] = node;
    }
}

// Class for Trie operations
class Trie {
    // Pointer to the root node
    private Node root;

    // Constructor to initialize the trie
    Trie() {
        root = new Node();
    }

    // Function to insert a number into the trie
    void insert(int num) {
        // Start from root
        Node node = root;

        // Traverse bits from MSB (31) to LSB (0)
        for (int i = 31; i >= 0; i--) {
            // Extract the current bit
            int bit = (num >> i) & 1;

            // If path for this bit doesn't exist, create it
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            // Move to the next node
            node = node.get(bit);
        }
    }

    // Function to find maximum XOR for a given number
    int findMax(int num) {
        // Start from root
        Node node = root;

        // Variable to store maximum XOR result
        int maxNum = 0;

        // Traverse bits from MSB to LSB
        for (int i = 31; i >= 0; i--) {
            // Extract the current bit
            int bit = (num >> i) & 1;

            // Try to take the opposite bit for maximizing XOR
            if (node.containsKey(1 - bit)) {
                // Set this bit in the result
                maxNum = maxNum | (1 << i);

                // Move to the opposite branch
                node = node.get(1 - bit);
            } 
            // If opposite bit doesn't exist, move to same bit branch
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

// Class containing the solution logic
class Solution {
    // Function to perform offline max XOR queries
    public List<Integer> maxXorQueries(List<Integer> arr,
                                       List<List<Integer>> queries) {

        // Result vector to store answers
        List<Integer> ans = new ArrayList<>(Collections.nCopies(queries.size(), 0));

        // Vector to store queries in {m, {x, original_index}} format
        List<int[]> offlineQueries = new ArrayList<>();

        // Sort the array in ascending order
        Collections.sort(arr);

        // Store queries with index for mapping answers later
        int index = 0;
        for (List<Integer> it : queries) {
            offlineQueries.add(new int[]{it.get(1), it.get(0), index++});
        }

        // Sort queries based on 'm'
        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        // Pointer for array traversal
        int i = 0;

        // Size of array
        int n = arr.size();

        // Initialize the trie
        Trie trie = new Trie();

        // Process each query in sorted order of 'm'
        for (int[] it : offlineQueries) {
            // Insert all elements ≤ m into the trie
            while (i < n && arr.get(i) <= it[0]) {
                trie.insert(arr.get(i));
                i++;
            }

            // If trie has at least one element
            if (i != 0)
                ans.set(it[2], trie.findMax(it[1]));
            // If no elements ≤ m, return -1
            else
                ans.set(it[2], -1);
        }
        return ans;
    }
}

// Driver class
public class MaxXor {
    public static void main(String[] args) {
        // Example array
        List<Integer> arr = Arrays.asList(3, 10, 5, 25, 2, 8);

        // Display the given array
        System.out.println("Given Array: " + arr);

        // Queries in {x, m} format
        List<List<Integer>> queries = Arrays.asList(
            Arrays.asList(0, 1), Arrays.asList(1, 2),
            Arrays.asList(0, 3), Arrays.asList(3, 3)
        );

        // Display queries
        System.out.println("Queries: " + queries);

        // Create solution object
        Solution obj = new Solution();

        // Get results for queries
        List<Integer> result = obj.maxXorQueries(arr, queries);

        // Display results
        System.out.println("Result of Max XOR Queries:");
        for (int i = 0; i < result.size(); ++i) {
            System.out.println("Query " + (i+1) + ": " + result.get(i));
        }
    }
}
