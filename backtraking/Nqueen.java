import java.util.*;
class Nqueen{
    private static boolean check(int row,int col,int[][]board ,int n)
    {

//row
        for(int i=0;i<col;i++)
        {
            if(board[row][i]==1)
            {
                return false;
            }
        }

//upper diag
        int i=row;
        int j=col;
        while(i<n && j>=0)
        {
            if(board[i][j]==1)
            {
                return false;
            }
            i++;
            j--;
        }
//lower diag
        i=row;
        j=col;
        while(i>=0 && j>=0)
        {
            if(board[i][j]==1)
            {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
    private static void solve(int[][] board,ArrayList<Integer>temp,int n,int colIdx)
    {
        if(colIdx>=n)
        {
            System.out.println(temp);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(check(i,colIdx,board,n))
            {
                board[i][colIdx]=1;
                temp.add(i+1);
                solve(board,temp,n,colIdx+1);
                board[i][colIdx]=0;
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int n  = sc.nextInt();
        int[][] board = new int[n][n];
        ArrayList<Integer> temp = new ArrayList<>();
        int colIdx=0;
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        solve(board,temp,n,colIdx);
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        

    }
}