class Suduko{
    public static boolean check(int[][]board,int rowIdx,int colIdx,int no)
    {
        for(int i=0;i<9;i++)
        {
            if(board[rowIdx][i]==no)
            {
                return false;
            }
        }
        for(int i=0;i<9;i++)
        {
            if(board[i][colIdx]==no)
            {
                return false;
            }
        }
        int boxrow = (rowIdx/3)*3;
        int boxcol = (colIdx/3)*3;
        for(int i=boxrow;i<(boxrow+3);i++)
        {
            for(int j=boxcol;j<(boxcol+3);j++)
            {
                if(board[i][j]==no)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solve(int rowIdx,int colIdx,int[][]board)
    {
        if(rowIdx==9)
        {
            System.out.println("After solve : ");
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        if(colIdx==9)
        {
            solve(rowIdx+1,0,board);
            return;
        }

        for(int i=1;i<=9;i++)
        {
            if(board[rowIdx][colIdx]==0)
            {
                if(check(board,rowIdx,colIdx,i))
                {
                    board[rowIdx][colIdx]=i;
                    solve(rowIdx,colIdx+1,board);
                    board[rowIdx][colIdx]=0;
                }
            }
            else{
                solve(rowIdx,colIdx+1,board);
                return;
            }
        }
    }

    public static void main(String args[])
    {
        
        int[][] board = new int[9][9];
        int rowIdx=0;
        int colIdx=0;
        board[0][0]=5;
        board[0][1]=3;
        board[0][4]=7;
        board[1][0]=6;
        board[1][3]=1;
        board[1][4]=9;
        board[1][5]=5;
        board[2][1]=9;
        board[2][2]=8;
        board[2][7]=6;
        board[3][0]=8;
        board[3][4]=6;
        board[3][8]=3;
        board[4][0]=4;
        board[4][3]=8;
        board[4][5]=3;
        board[4][8]=1;
        board[5][0]=7;
        board[5][4]=2;
        board[5][8]=6;
        board[6][1]=6;
        board[6][6]=2;
        board[6][7]=8;
        board[7][3]=4;
        board[7][4]=1;
        board[7][5]=9;
        board[7][8]=5;
        board[8][4]=8;
        board[8][7]=7;
        board[8][8]=9;

        // 2nd 

        // board[0][2]=6;
        // board[0][3]=3;
        // board[0][5]=4;
        // board[0][6]=2;
        // board[1][1]=3;
        // board[1][4]=7;
        // board[1][7]=8;
        // board[2][2]=7;
        // board[2][3]=9;
        // board[2][5]=2;
        // board[2][6]=3;
        // board[3][1]=5;
        // board[3][7]=1;
        // board[4][2]=2;
        // board[4][6]=6;
        // board[5][1]=4;
        // board[5][7]=9;
        // board[6][2]=9;
        // board[6][3]=7;
        // board[6][5]=8;
        // board[6][6]=4;
        // board[7][1]=2;
        // board[7][4]=5;
        // board[7][7]=7;
        // board[8][2]=5;
        // board[8][3]=2;
        // board[8][5]=6;
        // board[8][6]=1;


        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        solve(rowIdx,colIdx,board);
        



    }
}