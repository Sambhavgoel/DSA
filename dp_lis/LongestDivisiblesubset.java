import java.util.*;
class LongestDivisiblesubset {
    public static void printval(int n, int[]arr)
    {
        int[]dp = new int[n];
        int []hash = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(arr);

        int len=1;
        int index=0;

        for(int i=0;i<n;i++)
        {
            hash[i]=i;
            for(int j=0;j<i;j++)
            {
                if(arr[i]%arr[j]==0 && dp[i]<dp[j]+1)
                {
                    dp[i] = 1+dp[j];
                    hash[i]=j;
                }

            }
            if(len<dp[i])
            {
                len = dp[i];
                index = i;
            }
        }
        System.out.println("length : "+len);

        int[]ans = new int[len];
        int idx=1;
        ans[len-idx]=arr[index];
        while(hash[index]!=index)
        {
            idx++;
            index = hash[index];
            ans[len-idx] = arr[index];
        }
        for(int ele : ans)
        {
            System.out.println(ele+" ");
        }

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
        printval(n,arr);
    }
}
