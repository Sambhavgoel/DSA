import java.util.*;
class fact{
    public static int calculatefact(int n )
    {
        if(n==0)
        {
            return 1;
        }
        
        int ans = n*calculatefact(n-1);
        
        return ans;
        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = calculatefact(n);
        System.out.println(ans);
    }
}