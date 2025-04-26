import java.util.Scanner;
class bottomupfib{
    public int fib(int n)
    {
        int [] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++)
        {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        bottomupfib  calculate = new bottomupfib();
        
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        int res = calculate.fib(n);
        System.out.println("The fibonacci number is : "+res);


    }
}