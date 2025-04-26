import java.util.*;
class minCoins{
    public static void countcoins(int[]coins,int V,ArrayList<Integer>ans)
    {
        int len = coins.length;
        for(int i=len-1;i>=0;i--)
        {
            while(V>=coins[i])
            {
                V-=coins[i];
                ans.add(coins[i]);
            }
        }
        return;

    }
    public static void main(String args[])
    {
        int V=94;
        ArrayList<Integer> ans = new ArrayList<>();
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        countcoins(coins,V,ans);
        for(int i : ans)
        {
            System.out.println(i);
        }

    }
}