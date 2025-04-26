import java.util.*;
class convertzigzag{

    public void zigzag(int[]arr,int n)
    {
        Boolean flag = true;

        for(int i=0;i<n-1;i++)
        {
            if(flag==true)
            {
                if(arr[i+1]<arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]=temp;
                }
                flag = false;
            }
            else{
                if(arr[i+1]>arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]=temp;
                }
                flag = true;
            }
        }
        for(int j=0;j<n;j++)
        {
            System.out.print(arr[j]+" ");
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the array : ");
        int[] arr = new int [n];

        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        convertzigzag cal = new convertzigzag();

        cal.zigzag(arr,n);

    }
}