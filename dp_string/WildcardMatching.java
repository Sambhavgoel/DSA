import java.util.*;
public class WildcardMatching {
    public static boolean recur(String s1,String s2, int i, int j)
    {

        if(i<0 && j<0)return true;
        else if(i<0 && j>=0)return false;
        else if(j<0 && i>=0)
        {
            for(int a=0;a<=i;a++)
            {
                if(s1.charAt(a)!='*')
                {
                    return false;
                }
            }
            return true;
        }

        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')
        {
            return recur(s1,s2,i-1,j-1);
        }
        if(s1.charAt(i)=='*')
        {
            return recur(s1,s2,i-1,j)||recur(s1,s2,i,j-1);
        }
        
        return false;
        
    }
    public static boolean memo(String s1, String s2, int i,int j, int[][]dp)
    {
        if(i<0 && j<0)return true;
        if(i<0 && j>=0)return false;
        if(j<0 && i>=0)
        {
            for(int a=0;a<=i;a++)
            {
                if(s1.charAt(a)!='*')
                {
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j]!=-1){
            return (dp[i][j]==1)?true:false;
        }

        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')
        {
            boolean match  = memo(s1,s2,i-1,j-1,dp);
            dp[i][j] = (match)?1:0;
            return match;
        }
        if(s1.charAt(i)=='*')
        {
            boolean notmatch =  memo(s1,s2,i-1,j,dp)||memo(s1,s2,i,j-1,dp);
            dp[i][j] = (notmatch)?1:0;
            return notmatch;
        }
        
            dp[i][j]=0;
            return false;
        

    }
    public static boolean tabu(String s1, String s2, int n, int m)
    {
        boolean[][]dp = new boolean[n+1][m+1];

        dp[0][0]=true;
        for(int i=1;i<=m;i++)
        {
            dp[0][i]=false;
        }
        for(int i=1;i<=n;i++)
        {
            boolean flag=true;
            for(int a=0;a<=i;a++)
            {
                if(s1.charAt(a)!='*')
                {
                    flag = false;
                    break;
                }
            }
            dp[i][0]=flag;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1)||s1.charAt(i-1)=='?')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s1.charAt(i-1)=='*')
                {
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];


    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int n = s1.length();
        int m = s2.length();

        boolean ans = recur(s1,s2,n-1,m-1);
        System.out.println("recur : "+ans);

        int[][]dp  = new int[n][m];
        for(int []a : dp)
        {
            Arrays.fill(a,-1);
        }
        boolean res = memo(s1,s2,n-1,m-1,dp);
        System.out.println("memo : "+res);

        boolean findans = tabu(s1,s2,n,m);
        System.out.println("tabu : "+findans);

    }
}
