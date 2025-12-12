import java.util.*;
class LongestStringChain {
    public static Comparator<String>comp = (s1,s2)->s1.length()-s2.length();
    public static boolean check(String s1, String s2)
    {
        if(s1.length()!=s2.length()+1)return false;
        int i=0,j=0;
        while(i<s1.length())
        {
            if(j<s2.length() && s1.charAt(i)==s2.charAt(j))
            {
                i++;j++;
            }
            else{
                i++;
            }

        }
        return i==s1.length() && j==s2.length();

    }
    public static int cal(List<String>arr)
    {
        int n = arr.size();
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        int len=1;

        arr.sort(comp);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(check(arr.get(i),arr.get(j)) && 1+dp[j]>dp[i])
                {
                    dp[i]=1+dp[j];
                }
            }
            if(len<dp[i])
            {
                len=dp[i];
            }
        }
        return len;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        List<String>arr = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");
        int ans = cal(arr);
        System.out.println("ans : "+ans);


    }
}
