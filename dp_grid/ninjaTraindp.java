import java.util.*;
public class ninjaTraindp {
    public static int memo(int[][]points,int day,int last, int[][]dp)
    {
        if(day==0)
        {
            int max =0 ;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                {
                    max = Math.max(max,points[day][i]);
                }
            }
            dp[day][last]=max;
            return dp[day][last];
        }
        if(dp[day][last]!=-1)
        {
            return dp[day][last];
        }
        int max=0;
        for(int i=0;i<3;i++)
        {
            if(i!=last)
            {
                int point = points[day][i]+memo(points,day-1,i,dp);
                max = Math.max(max,point);
            }
            
        }
        dp[day][last] = max;
        return dp[day][last] ;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int[][]points = new int[day][3];

        for(int i=0;i<day;i++)
        {
            for(int j=0;j<3;j++)
            {
                points[i][j] = sc.nextInt();
            }
        }
        int[][]dp = new int[day][4];
        // Arrays.fill(dp,-1);
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }

        int ans = memo(points,day-1,3,dp);
        System.out.println(ans);
    }
}
