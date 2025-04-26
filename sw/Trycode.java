import java.util.*;
class Try {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        // Number of test cases
        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt(); // Length of array
            int k = sc.nextInt(); // Target bitwise AND
            
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
            {
                arr[j] = sc.nextInt(); // Read the array elements
            }
            
            int index = 0;
            boolean found = false;
            
            // Outer loop to slide the window
            while (index < n)
            {
                int currentAnd = arr[index]; // Start with one element
                
                // Check if the first element is the answer
                if (currentAnd == k)
                {
                    System.out.println("YES");
                    System.out.println(1); // Only one element
                    System.out.println(index + 1); // 1-based index
                    found = true;
                    break;
                }

                // Try expanding the window
                for (int end = index + 1; end < n; end++) {
                    currentAnd &= arr[end]; // Update the bitwise AND
                    
                    // Check if the AND of the current window equals K
                    if (currentAnd == k)
                    {
                        System.out.println("YES");
                        System.out.println(end - index + 1); // Window size
                        for (int i1 = index; i1 <= end; i1++) {
                            System.out.print((i1 + 1) + " "); // Print 1-based index
                        }
                        System.out.println();
                        found = true;
                        break;
                    }
                    
                    // If the AND becomes smaller than K, stop expanding the window
                    if (currentAnd < k)
                    {
                        break;
                    }
                }
                
                // If we found the answer, break out of the outer loop
                if (found)
                {
                    break;
                }
                
                // If not found, move to the next index (start a new window)
                index++;
            }
            
            // If no such subset is found
            if (!found) {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
