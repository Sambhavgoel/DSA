import java.util.*;

class Majority{
    private void solve(int[] arr) {
        int candidate = arr[0];
        int count = 0;

        // Step 1: Find the candidate
        for (int i : arr) {
            if (count == 0) {
                candidate = i;
                count = 1;
            } else if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Validate the candidate
        count = 0;
        for (int i : arr) {
            if (i == candidate) {
                count++;
            }
        }

        // If candidate count is greater than n/2, print it; otherwise, print -1
        if (count > arr.length / 2) {
            System.out.println(candidate);
        } else {
            System.out.println("-1");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solve(arr);
        sc.close(); // Close scanner to avoid resource leak
    }
}
