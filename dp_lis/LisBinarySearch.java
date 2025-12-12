import java.util.*;
class LisBinarySearch {
    public static int binary(int n, int[]arr)
    {
        ArrayList<Integer>temp = new ArrayList<>();
        temp.add(arr[0]);
        int len=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>temp.get(temp.size()-1))
            {
                temp.add(arr[i]);
                len++;
            }
            else{
                int bs = Collections.binarySearch(temp,arr[i]);
                if(bs<0)
                {
                    bs = -bs-1;
                }
                temp.set(bs,arr[i]);
            }
        }
        return len;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans = binary(n,arr);
        System.out.println("ans : " +ans);
    }
}
