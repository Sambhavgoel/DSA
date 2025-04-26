import java.util.*;
public class toweroh{
    static void toh(int left,int middle,int right,int n)
    {
        if(n==1)
        {
            System.out.println("Move the disc from "+left+" to "+right);
            return;
        }
        toh(left,right,middle,n-1);
        System.out.println("Move the disc from "+left+" to "+right);
        toh(middle,left,right,n-1);
        return;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = 1;
        int middle = 2;
        int right = 3;
        toh(left,middle,right,n);
    }
}