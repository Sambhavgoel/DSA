import java.util.*;
public class balanced_parenthesis
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        balanced(str);
    }
    public static boolean match(char a, char b)
        {
            if((a=='{'&& b=='}')||(a=='('&& b==')')||(a=='['&& b==']'))
            {
                return true;
            }
            return false;
        }
    public static void balanced(String str)
    {
        ArrayDeque<Character> ad = new ArrayDeque<Character>();
        int len = str.length();
        
        for(int i=0;i<len;i++)
        {
            if(str.charAt(i)=='[' || str.charAt(i)=='{' || str.charAt(i)=='(')
            {
                ad.push(str.charAt(i));
            }
            else{
                if(ad.isEmpty()==true)
                {
                    System.out.println("Not-Balanced");
                    return;
                }
                else if(match(ad.peek(),str.charAt(i))==false)
                {
                    System.out.println("Not-Balanced");
                    return;
                }
                else{
                    ad.pop();
                }
                

                
            }
        }
        if(ad.isEmpty()==true)
        {
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not-Balanced");
            return;
        }
    }
}
