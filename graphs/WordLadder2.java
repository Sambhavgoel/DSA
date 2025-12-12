import java.util.*;
class Pair{
    String word;
    int seq;
    Pair(String word,int seq)
    {
        this.word = word;
        this.seq=seq;
    }
}
public class WordLadder2 {
    static HashMap<String,Integer>map = new HashMap<>();
    static ArrayList<ArrayList<String>>res = new ArrayList<>();
    static String startWord;
     public static void bfs(String targetWord,ArrayList<String>ans)
    {

        int level = map.get(targetWord);
        ans.add(targetWord);

        if(targetWord.equals(startWord))
        {
            ArrayList<String>path = new ArrayList<>(ans);
            Collections.reverse(path);
            res.add(path);
            ans.remove(ans.size()-1);
            return;
        }

        for(int i=0;i<targetWord.length();i++)
        {
            char[]stringarr = targetWord.toCharArray();
            char original = stringarr[i];

            for(char ch = 'a';ch<='z';ch++)
            {
                stringarr[i]=ch;
                String newword = new String(stringarr);
                if(map.containsKey(newword))
                {
                    if(map.get(newword)==level-1)
                    {
                        
                        bfs(newword,ans);

                    }
                }
            }
            stringarr[i]=original;
        }

        ans.remove(ans.size()-1);

    }
    public static void solution(String sWord,String targetWord,String[]wordList)
    {
        startWord = sWord;
        Set<String>set = new HashSet<>(Arrays.asList(wordList));
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        map.put(startWord,1);
        set.remove(startWord);
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            String word = temp.word;
            int seq=temp.seq;

            if(word.equals(targetWord))
            {
                ArrayList<String>sequence = new ArrayList<>();
                bfs(targetWord,sequence);
                for (ArrayList<String> path : res) {
                    System.out.println(path);
                }
                return;
            }

            for(int i=0;i<word.length();i++)
            {
                char[] stringarr = word.toCharArray();
                char original = stringarr[i];

                for(char ch = 'a';ch<='z';ch++)
                {
                    stringarr[i]=ch;
                    String newword = new String(stringarr);
                    if(set.contains(newword))
                    {
                        set.remove(newword);
                        q.add(new Pair(newword,seq+1));
                        map.put(newword,seq+1);
                    }


                }
                stringarr[i]=original;

            }
        }
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
        
        solution(startWord,targetWord,wordList);
        
    }
}
