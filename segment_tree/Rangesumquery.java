import java.util.*;

public class Rangesumquery {

    public static void buildtree(int[] arr, ArrayList<Integer> tree, int idx, int left, int right) {
        if (left == right) {
            tree.set(idx, arr[left]);
            return;
        }

        int mid = left + ((right - left) / 2);
        buildtree(arr, tree, (2 * idx + 1), left, mid);
        buildtree(arr, tree, (2 * idx + 2), mid + 1, right);

        tree.set(idx, Math.max(tree.get(2 * idx + 1) , tree.get(2 * idx + 2)));

    }

    public static int query(int first, int second, int idx, int left, int right, ArrayList<Integer> tree) {

        if (second < left || first > right)
            return Integer.MIN_VALUE;
        if (first <= left && right <= second) {
            return tree.get(idx);
        }

        int mid = left + ((right - left) / 2);

        return Math.max(query(first, second, (2 * idx + 1), left, mid, tree)
                , query(first, second, (2 * idx + 2), mid + 1, right, tree));

    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 6 };
        int n = arr.length;
        ArrayList<Integer> tree = new ArrayList<>(Collections.nCopies(4 * n, 0));
        buildtree(arr, tree, 0, 0, n - 1);

        int[] queries = { 1, 2, 3, 4, 5, 6, 3, 6 };

        for (int i = 0; i < queries.length; i = i + 2) {
            int first = queries[i];
            int second = queries[i + 1];

            int ans = query(first, second, 0, 0, n - 1, tree);
            System.out.println(ans);

        }

    }

}
