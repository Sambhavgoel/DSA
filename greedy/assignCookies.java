import java.util.*;
class assignCookies{
    public static void assign(int[]greed,int[]cookies)
    {
        int n = greed.length;
        int m = cookies.length;

        int p=0;
        int q=0;
        Arrays.sort(greed);
        Arrays.sort(cookies);

        while(p<n && q<m)
        {
            if(cookies[q]>=greed[p])
            {
                p++;
            }
            q++;
        }
        System.out.println("children satisfied : "+(p));

    }
    public static void main(String args[])
    {
        int[] greed = {1, 5, 3, 3, 4};
        int[] cookieSize = {4, 2, 1, 2, 1, 3};

        assign(greed,cookieSize);
    }
}