import java.util.*;
public class robberHouse {
    public static long cal(ArrayList<Integer>arr)
    {   int n = arr.size();
        int prev=arr.get(0);
        int prev2=0;

        for(int i=1;i<n;i++)
        {
            int left = arr.get(i);
            if(i>1)
            {
                left+=prev2;
            }
            int right = prev;
            int cur = Math.max(left,right);
            prev2=prev;
            prev=cur;
        }
        return prev;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();

        }
        ArrayList<Integer>arr1 = new ArrayList<>();
        ArrayList<Integer>arr2 = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(i!=0)
            {
                arr1.add(arr[i]);
            }
            if(i!=(n-1))
            {
                arr2.add(arr[i]);
            }
        }
        long ans = Math.max(cal(arr1),cal(arr2));
        System.out.println("ans: "+ans);
    }
}
