import java.util.*;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int h : happiness) {
            pq.offer(h);
        }

        long ans = 0;
        int ded = 0;

        while (k > 0 && !pq.isEmpty()) {
            int curr = pq.poll() - ded;
            if (curr <= 0) break;

            ans += curr;
            ded++;
            k--;
        }

        return ans;
    }
}


public class lc3075 {
    public static void main(String args[])
    {
        int[]happiness = new int[]{1,2,3};
        int k=2;
        Solution solution = new Solution();
        long ans = solution.maximumHappinessSum(happiness,k);
        System.out.println(ans);

    }
}
