import java.util.*;
class permuwithstring{
    private static String swap(String ip,int i,int start)
    {
        char[]ch = ip.toCharArray();

        char temp = ch[i];
        ch[i]=ch[start];
        ch[start]=temp;
        return String.valueOf(ch);
    }

    private static void solve(String ip,int start,HashSet<String>ans)
    {
        if(start==ip.length()-1)
        {
            ans.add(ip);
            return;
        }
        HashSet<Character> dupli = new HashSet<>();
        for(int i=start;i<=(ip.length()-1);i++)
        {
            if(!dupli.contains(ip.charAt(i)))
            {
                dupli.add(ip.charAt(i));
                ip=swap(ip,i,start);
                solve(ip,start+1,ans);
                ip=swap(ip,i,start);
            }
        }
    }

    public static void main(String args[])
    {
        HashSet<String> ans = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String ip = sc.nextLine();
        int start=0;
        solve(ip,start,ans);
        System.out.println(ans);
    
    }
}