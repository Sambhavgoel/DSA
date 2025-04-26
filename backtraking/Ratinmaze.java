import java.util.*;
class Ratinmaze{
    private static void solve(int sr,int sc,int er,int ec,String path,int[][]mat)
    {
        
        if(sr>er || sc>ec) return ;
        if(sr<0 || sc<0) return;
        if(mat[sr][sc]==1) return;
        if(sr==er && sc==ec)
        {
            System.out.println(path);
            return;
        }
            mat[sr][sc]=1;
            solve(sr-1,sc,er,ec,path+"U",mat);
            solve(sr+1,sc,er,ec,path+"D",mat);
            solve(sr,sc-1,er,ec,path+"L",mat);
            solve(sr,sc+1,er,ec,path+"R",mat);
            mat[sr][sc]=0;
       
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows : ");
        int n = sc.nextInt();
        int m =sc.nextInt();
        int[][]mat = new int[n][m];
        System.out.println("Enter the elemenets of matrix : ");

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }
        String path="";
        // Choice choices = new Choice({'U',1,0},{'D',-1,0},{'L',0,1}{'R',0,-1});
        solve(0,0,n-1,m-1,path,mat);

        // solve(mat,n,path);

    }
}