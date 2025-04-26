import java.util.*;

class twosum{

    public static void ans(int[]a , int target)
    {
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();

        for(int i=0;i<a.length;i++)
        {
            mp.put(a[i],i);
        }
        int j=-1;
        for(int i=0;i<a.length;i++)
        {
            int ans = target-a[i];
            
            if(mp.containsKey(ans))
            {
                j=mp.get(ans);
                System.out.println("The indexes are : "+i+" and "+ j);
                break;
            }
        }
        if(j==-1)
        {
            System.out.println("The sum is not possible with these values");
        }

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements in the array : ");

        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target value : ");
        int target = sc.nextInt();

        ans(arr,target);
    }
}