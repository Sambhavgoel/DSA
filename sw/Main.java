import java.util.*;

public class Main {

    // Function to find the window with AND equal to K using a sliding window technique
    public static boolean findWindowWithAnd(int[] arr, int N, int K) {
        // Sliding window: We use two pointers, start and end
        for (int start = 0; start < N; start++) {
            int currentAnd = arr[start]; // Start with a window of size 1
            
            // If the AND of just arr[start] is already equal to K, return it
            if (currentAnd == K) {
                System.out.println("YES");
                System.out.println(1); // The window size is 1
                System.out.println(start + 1); // 1-based index
                return true;
            }

            // Expand the window by adding elements
            for (int end = start + 1; end < N; end++) {
                currentAnd &= arr[end]; // Perform AND with the new element

                if (currentAnd == K) {
                    // If the AND matches K, print the window
                    System.out.println("YES");
                    System.out.println(end - start + 1); // The size of the window
                    for (int i = start; i <= end; i++) {
                        System.out.print((i + 1) + " "); // Print 1-based indices
                    }
                    System.out.println();
                    return true;
                }

                // If the AND becomes less than K, we can stop expanding the window
                if (currentAnd < K) {
                    break;
                }
            }
        }

        // If no such window is found
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int T = sc.nextInt();
        
        // Process each test case
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // Size of the array
            int K = sc.nextInt(); // Target AND value
            
            // Read the array elements
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            // Try to find the window with AND equal to K
            if (!findWindowWithAnd(arr, N, K)) {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
