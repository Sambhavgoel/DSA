import java.util.*;

class dutchnationalflag{
    public void sort(int n ,int arr[])
    {
        int left = 0;
        int mid = 0;
        int right = n-1;
        while(mid<=right)
        {
            if(arr[mid]==0)
            {
                int temp = arr[mid];
                arr[mid] = arr[left];
                arr[left] = temp;

                left++;
                mid++;
            }
            else if(arr[mid]==1)
            {
                mid++;
            }
            else{
                int temp2 = arr[mid];
                arr[mid] = arr[right];
                arr[right] = temp2;

                
                right--;
            }
            
        }
        System.out.println("The sorted array is : ");
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the size of array  : ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Enter the elements of array from 0,1 and 2 only : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        dutchnationalflag cal = new dutchnationalflag();
        cal.sort(n,arr);
        

    }
}