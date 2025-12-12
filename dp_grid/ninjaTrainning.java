import java.util.*;
public class ninjaTrainning {
    public static int recur(int days,int[][]table,int last)
    {
        if(days==0)
        {
            int max=0;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                {
                    max = Math.max(max,table[0][i]);
                }
            }
            return max;
        }
        int max=0;
        
            for(int j=0;j<3;j++)
            {
                if(j!=last)
                {
                    int points = table[days][j]+recur(days-1,table,j);
                    max = Math.max(max,points);
                }
            }
        
        return max;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int[][]table = new int[days][3];
        for(int i=0;i<days;i++)
        {
            for(int j=0;j<3;j++)
            {
                table[i][j] = sc.nextInt();
            }
        }
        int ans  = recur(days-1,table,3);
        System.out.println("ans : "+ans);
    }
}
