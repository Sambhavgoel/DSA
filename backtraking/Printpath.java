import java.util.*;
class Printpath{
    private static void solve(int sr,int sc,int er,int ec,String path)
    {
        if(sr>er || sc>ec) return ;
        if(sc==ec && sr==er)
        {
            System.out.println(path);
            return;
        }
        solve(sr+1,sc,er,ec,path+"D");
        solve(sr,sc+1,er,ec,path+"R");
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        String path="";
        solve(1,1,row,col,path);
    }
}