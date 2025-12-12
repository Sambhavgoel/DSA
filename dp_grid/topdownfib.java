import java.util.Scanner;
class topdownfib{
    public int fib(int arr[],int n)
    {
        if(arr[n]==0)
        {
            if(n<2)
            {
                arr[n]=n;
            }
            else
            {
                int left = fib(arr,n-1);
                int right = fib(arr,n-2);
                arr[n]=left+right;
            }
        }
        return arr[n];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a number ");
        int n =sc.nextInt();
        topdownfib calculate = new topdownfib();
        int res = calculate.fib(new int [n+1], n);
        System.out.println("The value of fibbonacci number is : "+res);

    }
}