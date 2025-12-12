import java.util.*;

class Lisprint {
    public static int tabu(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int len = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }
    // public static String printval(int n, int[]arr)
    // {
    // int[]dp = new int[n];
    // int[]hash = new int[n];
    // int index=0;
    // // for(int i=0;i<n;i++)
    // // {
    // // hash[i]=i;
    // // }
    // Arrays.fill(dp,1);

    // int max=1;

    // for(int i=0;i<n;i++)
    // {
    // hash[i]=i;
    // for(int j=0;j<i;j++)
    // {
    // if(arr[j]<arr[i] && dp[i]<1+dp[j])
    // {
    // dp[i] = 1+dp[j];
    // hash[i]=j;
    // }
    // }
    // if(dp[i]>max)
    // {
    // max=dp[i];
    // index=i;
    // }
    // }
    // System.out.println(max);
    // StringBuilder sb = new StringBuilder("");
    // sb.append(arr[index]);

    // while(hash[index]!=index)
    // {
    // index=hash[index];
    // sb.append(arr[index]);
    // }
    // return sb.reverse().toString();

    // }

    public static void printval(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash = new int[n];

        int len = 1;
        int index = 0;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }

            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }

        System.out.println("len : " + len);

        int[] ans = new int[len];
        int idx = 1;
        ans[len - idx] = arr[index];

        while (hash[index] != index ) {
            idx++;
            index = hash[index];
            ans[len - idx] = arr[index];
        }

        for(int ele : ans)
        {
            System.out.print(ele+" ");
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = tabu(n, arr);
        System.out.println("tabu : " + ans);

        printval(n, arr);
        

    }
}
