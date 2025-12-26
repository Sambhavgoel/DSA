public class lc2483 {
    class Solution {
        public static int bestClosingTime(String customers) {
            int n = customers.length();

            int minHour = 0;

            // Count total 'Y' initially (penalty if shop closes at hour 0)
            int penalty = 0;
            for (int i = 0; i < n; i++) {
                if (customers.charAt(i) == 'Y') {
                    penalty++;
                }
            }

            int minPenalty = penalty;

            for (int i = 0; i < n; i++) {

                if (customers.charAt(i) == 'Y') {
                    penalty--; // one less unhappy customer before closing
                } else {
                    penalty++; // one more unhappy customer after closing
                }

                if (penalty < minPenalty) {
                    minPenalty = penalty;
                    minHour = i + 1;
                }
            }

            return minHour;
        }

        public static void main(String args[]) {
            String str = "YYNY";
            int ans = bestClosingTime(str);
            System.out.println(ans);
        }
    }

}
