import java.util.*;
class NumLIS {
    public static int cal(int n, int[]arr)
    {
        int[]dp = new int[n];
        int []count = new int[n];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && dp[i]<1+dp[j])
                {
                    dp[i]=1+dp[j];
                    count[i]=count[j];
                }
                else if(arr[i]>arr[j] && dp[i]==1+dp[j]){
                    count[i]+=count[j];
                }
            }
        }
        int res=1;
        for(int i=0;i<n;i++)
        {
            res = Math.max(res,count[i]);
        }
        return res;



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
