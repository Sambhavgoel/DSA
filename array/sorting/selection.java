import java.util.Scanner;

class selection{
    public static void swap(int[]a,int i,int j)
    {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void selection_sort(int[]a,int n)
    {
        for(int i=0;i<n-1;i++)
        {
            int minimum = i;
            for(int j=i+1;j<n;j++)
            {
                if(a[j]<a[minimum])
                {
                    minimum = j;
                }
            }
            swap(a,i,minimum);
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

        selection_sort(arr,n);

        System.out.println("The sorted array is :  ");

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}