import java.util.*;
class Pallindromepartition{
    private static boolean ispallindrome(String ip)
    {
        int i=0;
        int j=ip.length()-1;
        while(i<j)
        {
            if(ip.charAt(i)==ip.charAt(j))
            {
                i++;j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private static void solve(int start,String ip,ArrayList<String> op)
    {
        if(start==ip.length())
        {
            System.out.println(op);
            return;
        }
        
        for(int i=start;i<ip.length();i++)
        {
            String pal = ip.substring(start,i+1);

            if(ispallindrome(pal))
            {
                op.add(pal);
                // ip = ip.substring(i+1,ip.length());
                solve(i+1,ip,op);
                op.remove(op.size()-1);

            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
        int start=0;
        ArrayList<String> op = new ArrayList<String>();
        
        solve(start,str,op);
    }
}