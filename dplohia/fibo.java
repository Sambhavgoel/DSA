import java.util.*;
class fibo{

    private static int fibo(int n,int[]arr)
    {
        if(arr[n]==-1)
        {
            arr[n]= fibo(n-1,arr)+fibo(n-2,arr);
        }
        return arr[n];

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
        arr[0]=0;
        arr[1]=1;
        int ans = fibo(n,arr);
        // for(int i:arr)
        // {
        //     System.out.println(i);
        // }
        System.out.println(ans);
    }
}