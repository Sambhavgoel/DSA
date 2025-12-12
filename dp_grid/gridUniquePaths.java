import java.util.*;
public class gridUniquePaths {
    public static int count(int i , int j )
    {
        if(i==0 && j==0)
        {
            return 1;
        }
        if(i<0 || j<0)
        {
            return 0;
        }

        int left = count(i,j-1);
        int up = count(i-1,j);

        return up+left;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int ans = count(m-1,n-1);
        System.out.println("ans : "+ans);


    }
}
