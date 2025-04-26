import java.util.*;
class Stringsubset{
    private static String swap(int i,int start, String ip)
    {
        char[]ch = ip.toCharArray();
        char temp = ch[i];
        ch[i] = ch[start];
        ch[start]=temp;
        return String.valueOf(ch);
    }
    private static void subset(int start,String ip,HashSet<String>ans)
    {
        if(start==ip.length()-1)
        {
            ans.add(ip);
            return;
        }
        HashSet<Character>dupli = new HashSet<>();

        for(int i=start;i<ip.length();i++)
        {

            if(!dupli.contains(ip.charAt(i)))
            {
                dupli.add(ip.charAt(i));
                ip=swap(start,i,ip);
                
                subset(start+1,ip,ans);
                ip=swap(start,i,ip);
            }


        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String ip= sc.next();
        
        int start=0;
        HashSet<String> ans = new HashSet<>();
        subset(start,ip,ans);
        System.out.println(ans);
    }
}