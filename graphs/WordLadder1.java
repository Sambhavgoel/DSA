import java.util.*;
public class WordLadder1 {
    static class Pair{
        String word;
        int len;
        Pair(String word, int len)
        {
            this.word=word;
            this.len=len;
        }
    }
    public static int bfs(String startword, String targetword, String[]wordlist)
    {
        Set<String>hs = new HashSet<>();
        for(String i:wordlist)
        {
            hs.add(i);
        }
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(startword,1));
        hs.remove(startword);

        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            if(temp.word.equals(targetword)==true)
            {
                return temp.len;
            }

            String s = temp.word;

            for(int i=0;i<s.length();i++)
            {
                for(char j='a';j<='z';j++)
                {
                    char[]arr = s.toCharArray();
                    arr[i]=j;
                    String newstr = new String(arr);

                    if(hs.contains(newstr))
                    {
                        hs.remove(newstr);
                        q.add(new Pair(newstr,temp.len+1));
                    }
                }
            }
        }
        return 0;


    }
    public static void main(String args[])
    {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };

        int ans = bfs(startWord,targetWord,wordList);
        System.out.println(ans);
    }
}
