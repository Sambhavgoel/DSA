import java.util.*;
public class Permuwithstr{
    private static void solve(String ip,String op,HashSet<String>hs)
    {
        if(ip.length()==0)
        {
            hs.add(op);
            return;
        }
        HashSet<Character> idx = new HashSet<>();
        for(int i=0;i<ip.length();i++)
        {
            
            if(!idx.contains(ip.charAt(i)))
            {
                idx.add(ip.charAt(i));
                // hs.add(ip.charAt(i));
                String new_ip=ip.substring(0,i)+ip.substring(i+1);
                String new_op = op+ip.charAt(i);
                solve(new_ip,new_op,hs);
            }

        }
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String op = "";
        HashSet<String> hs = new HashSet<>();
        solve(ip,op,hs);
        System.out.println(hs);
    }
}