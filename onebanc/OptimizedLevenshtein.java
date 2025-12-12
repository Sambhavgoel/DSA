public class OptimizedLevenshtein {

    public static int EditDistance(String s1, String s2, int Ci, int Cd, int Cs) {
        int m = s1.length();
        int n = s2.length();
        if (m < n) {
            return EditDistance(s2, s1, Cs, Ci, Cd);
        }

        int[] previousRow = new int[n + 1];
        int[] currentRow = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            previousRow[j] = j * Ci;
        }

        for (int i = 1; i <= m; i++) {
            currentRow[0] = i * Cd;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    currentRow[j] = previousRow[j - 1];
                } else {
                    currentRow[j] = Math.min(Math.min(previousRow[j] + Cd,
                                                       currentRow[j - 1] + Ci),
                                                       previousRow[j - 1] + Cs);
                }
            }
            int[] temp = previousRow;
            previousRow = currentRow;
            currentRow = temp;
        }

        return previousRow[n];
    }

    public static void main(String[] args) {
        System.out.println(EditDistance("kitten", "sitting", 1, 2, 3));
        System.out.println(EditDistance("flaw", "lawn", 2, 2, 1));
        System.out.println(EditDistance("algorithm", "logarithm", 1, 3, 2));
    }
}