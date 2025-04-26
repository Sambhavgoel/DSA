import java.util.Scanner;

class bubble{
    public static void swap(int[]a,int i,int j)
    {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void bubble_sort(int[]a,int n)
    {
        for(int i=n-1;i>0;i--)
        {
            int didswap=0;
            for(int j=0;j<n-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    swap(a,j+1,j);
                    didswap=1;
                }
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

        bubble_sort(arr,n);

        System.out.println("The sorted array is :  ");

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}