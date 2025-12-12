import java.util.Scanner;
class maxsumsubarr{
    public int maxsum(int [] arr)
    {
        int current = arr[0];
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            current = current+arr[i];
            if(current<arr[i])
            {
                current = arr[i];
            }
            if(max<current)
            {
                max=current;
            }
        }
        return max;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the array ");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        maxsumsubarr start = new maxsumsubarr();
        int res = start.maxsum(arr);
        System.out.println("The minimum sub array sum is: "+res);

    }
}