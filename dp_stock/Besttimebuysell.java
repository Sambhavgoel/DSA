import java.util.*;
class Besttimebuysell  {
    public static int find(int n, int[]arr)
    {
        int min = arr[0];
        int profit=0;
        for(int i=1;i<arr.length;i++)
        {
            int cost = arr[i]-min;
            min = Math.min(min,arr[i]);

            profit = Math.max(profit,cost);
        }
        return profit;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int max = find(n,arr);
        System.out.println("max profit : "+max);
    }
}
