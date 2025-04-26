import java.util.*;

class reversearringroup{
    public void reverse(ArrayList<Integer>arr,int k,int i,int n)
    {
        int l=i;
        int r=Math.min(n-1,i+k-1);
        while(l<r)
        {
            int temp=arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r,temp);
            l++;
            r--;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);


        ArrayList<Integer>arr = new ArrayList<Integer>();
        System.out.println("Enter the size of array  : ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of array : ");
        for(int i=0;i<n;i++)
        {
            arr.add(sc.nextInt());
        }
        
        System.out.println("Enter the value of group k : ");
        int k = sc.nextInt();

        reversearringroup cal = new reversearringroup();

        for(int i=0;i<n;i+=k)
        {
            cal.reverse(arr,k,i,n);
        }

        for(int j=0;j<n;j++)
        {
            System.out.print(arr.get(j));
        }
    }
}