import java.util.*;
class MincosttocutStick {
    public static int recur(ArrayList<Integer>arr, int i, int j)
    {
        if(i>j)
        {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int idx = i;idx<=j;idx++)
        {
            int cost = (arr.get(j+1)-arr.get(i-1))+recur(arr,i,idx-1)+recur(arr,idx+1,j);
            min = Math.min(min,cost);
        }
        return min;
    }
    public static int memo(ArrayList<Integer>arr, int i, int j, int[][]dp)
    {
        if(i>j)return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        int min = Integer.MAX_VALUE;

        for(int idx = i;idx<=j;idx++)
        {
            int cost = (arr.get(j+1)-arr.get(i-1))+memo(arr,i,idx-1,dp)+memo(arr,idx+1,j,dp);
            min = Math.min(min,cost);
        }

        return dp[i][j]=min;

    }
    public static int tabu(int cuts, ArrayList<Integer>arr)
    {
        int[][]dp = new int[cuts+2][cuts+2];

        for(int i=(cuts);i>=1;i--)
        {
            for(int j=1;j<=cuts;j++)
            {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = arr.get(j + 1) - arr.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }
        return dp[1][cuts];

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer>arr = new ArrayList<>();
        int cuts= sc.nextInt();

        for(int i=0;i<cuts;i++)
        {
            arr.add(sc.nextInt());
        }
        arr.add(0);
        arr.add(n);

        Collections.sort(arr);

        int ans = recur(arr,1,cuts);
        System.out.println("recur : "+ans);

        int[][]dp = new int[cuts+1][cuts+1];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1);
        }
        int res = memo(arr,1,cuts,dp);
        System.out.println("memo : "+res);

        int findans = tabu(cuts,arr);
        System.out.println("tabu : "+findans);

    }
}
