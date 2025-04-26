import java.util.HashMap;
import java.util.Scanner;

public class tribonacci{

    public int fib(int n , HashMap<Integer,Integer> memo)
    {
        if(n==0 || n==1)
        {
            return 0;
        }
        if(n==2)
        {
            return 1;
        }

        if(memo.containsKey(n))
        {
            return memo.get(n);
        }

        int res = fib(n-1,memo) + fib(n-2,memo) + fib(n-3,memo);

        memo.put(n,res);

        return res;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        tribonacci cal = new tribonacci();
        int res = cal.fib(n , new HashMap<>());
        System.out.println("The fibonacci number is : "+ res);

    }
}