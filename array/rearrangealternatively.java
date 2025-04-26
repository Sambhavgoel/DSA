import java.util.*;

class rearrangealternatively{
    public void rearrange(int[]arr,int n)
    {
        int j =0;
        int k = n-1;
        int key = arr[n-1]+1;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                arr[i] = (arr[k]%key)*key+arr[i];
                k--;
            }
            else{
                arr[i] = (arr[j]%key)*key+arr[i];
                j++;
            }
        }
        for(int i=0;i<n;i++)
        {
            arr[i] = arr[i]/key;
            
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the sorted elements of the array : ");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        rearrangealternatively cal = new rearrangealternatively();
        cal.rearrange(arr,n);
    }
}