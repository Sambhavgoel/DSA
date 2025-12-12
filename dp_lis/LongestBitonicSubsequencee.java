import java.util.*;
class LongestBitonicSubsequencee {

    public static int cal(int n, int[]arr)
    {
        int dp1[] = new int[n];
        Arrays.fill(dp1,1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && dp1[i]<dp1[j]+1)
                {
                    dp1[i]=1+dp1[j];
                }
            }
        }

        int dp2[] = new int[n];
        Arrays.fill(dp2,1);
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(arr[i]>arr[j] && dp2[i]<dp2[j]+1)
                {
                    dp2[i]=dp2[j]+1;
                }
            }
        }

        int len=0;
        for(int i=0;i<n;i++)
        {
            len = Math.max(len,dp1[i]+dp2[i]-1);
        }
        return len;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        int ans = cal(n,arr);
        System.out.println("ans : "+ans);

    }
}
