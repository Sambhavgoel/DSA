import java.util.*;
class Wordbreak{
    private static void solve(String word,ArrayList<String>dict,ArrayList<String>sol,int start,int len)
    {
        if(start==word.length())
        {
            System.out.println(sol);
            return;
        }
        
        for(int i=start;i<word.length();i++)
        {
            String ip = word.substring(start,i+1);
            if(dict.contains(ip))
            {
                sol.add(ip);
                // System.out.println(word.substring(i+1,word.length()));
                // System.out.println(sol);
                solve(word,dict,sol,i+1,len);
                sol.remove(sol.size()-1);
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String word = sc.next();
        System.out.println("Enter the number of word in dictionary : ");
        int n = sc.nextInt();
        ArrayList <String> dict = new ArrayList<>();
        System.out.println("Enter n words in dictionary : ");
        for(int i=0;i<n;i++)
        {
            dict.add(sc.next());
        }
        ArrayList<String>sol = new ArrayList<>();
        int start=0;
        int len = word.length();
        solve(word,dict,sol,start,len);

    }
}