import java.util.*;
class Mazepath{
    private static int solve(int sr,int sc,int er,int ec)
    {
        if(sc>ec || sr>er) return 0;
        
        if(sc==ec && sr==er)
        {
            return 1;
        }
        return solve(sr+1,sc,er,ec)+solve(sr,sc+1,er,ec);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = solve(1,1,n,m);
        System.out.println(ans);
    }
}