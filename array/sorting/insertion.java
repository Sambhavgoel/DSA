import java.util.Scanner;

class insertion{
    public static void swap(int[]a,int i,int j)
    {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void insertion_sort(int[]arr,int n)
    {
        for(int i=1;i<n;i++)
        {
            int didswap=0;
            int j=i;
            while(j>0 && arr[j-1]>arr[j])
            {
                swap(arr,j-1,j);
                j--;
                didswap=1;
            }
            if(didswap==0)
            {
                break;
            }
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

        insertion_sort(arr,n);

        System.out.println("The sorted array is :  ");

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}