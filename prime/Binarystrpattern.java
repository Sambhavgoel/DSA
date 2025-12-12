import java.util.*;
public class Binarystrpattern {

    public static void backtrack(String[]str,int len,ArrayList<String>arr,String ip)
    {
        if(ip.length()==len)
        {
            arr.add(ip);
            return ;
        }

        if(ip.length()>=1)
        {
            if(ip.charAt(ip.length()-1)=='0')
            {
                backtrack(str,len,arr,ip+"1");
                backtrack(str,len,arr,ip+"0");
            }
            else{
                backtrack(str,len,arr,ip+"0");
            }
        }
        else{
            backtrack(str,len,arr,ip+"1");
            backtrack(str,len,arr,ip+"0");
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[]str = {"0","1"};
        ArrayList<String>arr = new ArrayList<>();
        String ip = "";

        backtrack(str,len,arr,ip);
        for(String a : arr)
        {
            System.out.println(a);
        }

    }
}
