import java.util.*;
public class tabuNinjaTrain {

    public static int optimize(int[][]points, int[]arr,int days)
    {
        arr[0] = Math.max(points[0][1],points[0][2]);
        arr[1] = Math.max(points[0][0],points[0][2]);
        arr[2] = Math.max(points[0][0],points[0][1]);
        arr[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day=1;day<days;day++)
        {
            int[]temp = new int[4];
            for(int last=0;last<4;last++)
            {
                
                temp[last]=0;
                for(int task=0;task<3;task++)
                {
                    if(task!=last)
                    {
                        temp[last]=Math.max(temp[last],points[day][task]+arr[task]);
                    }
                    
                }
            }
            arr=temp;
        }

        return arr[3];

        
    }
    public static int tabu(int[][]points, int[][]dp, int days)
    {
        
        {
            
            dp[0][0] = Math.max(points[0][1],points[0][2]);
            dp[0][1] = Math.max(points[0][0],points[0][2]);
            dp[0][2] = Math.max(points[0][0],points[0][1]);
            dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

            
        }
        for(int day=1;day<days;day++)
        {
            for(int last=0;last<4;last++)
            {
                dp[day][last]=0;
                for(int i=0;i<3;i++)
                {
                    if(i!=last)
                    {
                        int maxpoint = points[day][i]+dp[day-1][i];
                        dp[day][last] = Math.max(dp[day][last],maxpoint);
                    }
                }
            }
        }
        return dp[days-1][3];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int[][]points = new int[days][3];
        for(int i=0;i<days;i++)
        {
            for(int j=0;j<3;j++)
            {
                points[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[days][4];
        int[]arr = new int[4];
        // Arrays.fill(arr,-1);

        int ans = tabu(points,dp,days);
        int res  = optimize(points,arr,days);
        System.out.println("ans : "+ans);
        System.out.println("optimize : "+res);
    
    }
}
