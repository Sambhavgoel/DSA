import java.util.*;

class validParen{
    public static boolean valid(String ip)
    {
        String []arr = ip.split("");
        int min=0;
        int max=0;
        if(arr[0].equals(')'))
        {
            return false;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].equals('('))
            {
                min++;
                max++;
            }
            else if(arr[i].equals(')'))
            {
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min<0)
            {
                min=0;
            }
            if(max<0)
            {
                return false;
            }
        }
        if(min==0)
        {
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        String ip = "(*)";
        boolean ans = valid(ip);
        if(ans)
        {
            System.out.println("Valid");
        }
        else{
            System.out.println("Not valid");
        }
    }
    
}