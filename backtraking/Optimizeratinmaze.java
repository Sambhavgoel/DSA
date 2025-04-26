import java.util.*;
class Choice{
    char direction;
    int dx,dy;
    public Choice(char direction,int dx,int dy)
    {
        this.direction = direction;
        this.dx = dx;
        this.dy = dy;
    }

}
class Optimizeratinmaze{
    private static void solve(int sr,int sc,int er,int ec,int[][]mat,Choice[] choices,String path)
    {
        if(sr>er || sc>ec)return;
        if(sr<0 || sc<0)return;
        if(mat[sr][sc]==1)return;
        if(sr==er && sc==ec)
        {
            System.out.println(path);
            return;
        }
        


        mat[sr][sc]=1;
        for(Choice choice: choices)
        {
            solve(sr+choice.dx,sc+choice.dy,er,ec,mat,choices,path+choice.direction);
        }
        mat[sr][sc]=0;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int m = sc.nextInt();
        int[][]mat  = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }
        String path = "";
        Choice[] choices={
            new Choice('U',-1,0),new Choice('D',1,0),new Choice('L',0,-1),new Choice('R',0,1)};
        
        solve(0,0,n-1,m-1,mat,choices,path);

    }
}