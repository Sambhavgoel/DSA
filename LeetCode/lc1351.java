import java.util.*;

class lc1351 {
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] temp : grid) {
            int l = 0;
            int r = temp.length - 1;
            int ans = temp.length;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (temp[mid] < 0) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            count += (temp.length - ans);
        }
        return count;
    }

    public static void main(String[] args) {
        

        int[][] grid = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };

        int result = countNegatives(grid);
        System.out.println("Total negative numbers: " + result);
    }
}
