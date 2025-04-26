import java.util.*;
class Phonenumber{
    public static void solve(int idx,String num,String ans,HashMap<Character,String>hash)
    {
        if(idx  == num.length())
        {
            System.out.println(ans);
            return;
        }

        char ip = num.charAt(idx);
        String digit = hash.get(ip); 

        if(digit.isEmpty())
        {
            solve(idx+1,num,ans,hash);
            return;
        }
        
        for(char letter : digit.toCharArray())
        {
            solve(idx+1,num,ans+letter,hash);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,String> hash = new HashMap<>();
        hash.put('0',"");
        hash.put('1',"");
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        String num = sc.next();
        String ans ="";
        solve(0,num,ans,hash);
    }
}