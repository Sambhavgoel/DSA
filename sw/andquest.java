import java.util.*;

public class andquest {

    // Function to find a subset with AND equal to K using sliding window
    public static boolean findSubsetWithAnd(int[] arr, int N, int K) {
        // Variable sliding window
        for (int start = 0; start < N; start++) {
            int currentAnd = arr[start]; // Start with the element at 'start'
            
            if (currentAnd == K) {
                // If the first element itself matches K, print it
                System.out.println("YES");
                System.out.println(1);
                System.out.println(start + 1); // 1-based index
                return true;
            }

            // Expand the window by adding elements
            for (int end = start + 1; end < N; end++) {
                currentAnd &= arr[end]; // Compute the AND of the window
                
                if (currentAnd == K) {
                    // Found a window with AND equal to K
                    System.out.println("YES");
                    System.out.println(end - start + 1);
                    for (int i = start; i <= end; i++) {
                        System.out.print((i + 1) + " "); // Print 1-based index
                    }
                    System.out.println();
                    return true;
                }
                
                // If AND becomes 0 or less than K, there's no point in expanding further
                if (currentAnd < K) {
                    break;
                }
            }
        }
        
        // If no such subset is found
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of test cases
        int T = sc.nextInt();
        
        // Process each test case
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            
            // Read the array of integers
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            // Try to find the subset with AND equal to K using sliding window
            if (!findSubsetWithAnd(arr, N, K)) {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
