import java.util.*;

public class FloodfillAlgo {
    public static void main(String args[])
    {
        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };

        int n = image.length;
        int m = image[0].length;
        int[][]visited = new int[n][m];

        int inirow = 1;
        int inicol=1;
        int newcolor = 2;



        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }


        int inicolor = image[inirow][inicol];
        dfs(inirow, inicol,inicolor,newcolor,image,visited,n,m);

        System.out.println();


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }



    }
    public static void dfs(int inirow, int inicol, int inicolor, int newcolor, int[][]image,int[][]visited,int n, int m)
    {
        image[inirow][inicol] = newcolor;
        visited[inirow][inicol] = 1;

        int[]dr ={0,0,-1,1};
        int[]dc= {1,-1,0,0};

        for(int i=0;i<4;i++)
        {
            int newrow = inirow+dr[i];
            int newcol = inicol+dc[i];

            if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && visited[newrow][newcol]==0 && image[newrow][newcol]==inicolor)
            {
                dfs(newrow,newcol,inicolor,newcolor,image,visited,n,m);
            }
        }
        
    }
}
