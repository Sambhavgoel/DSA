import java.util.*;
class number{
    public static void printnum(int n)
    {
        if(n==1)
        {
            System.out.println(1);
            return;
        }
        
        printnum(n-1);
        System.out.println(n);
        return;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printnum(n);
    }
}