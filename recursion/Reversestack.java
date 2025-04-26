import java.util.*;
public class Reversestack{
    static void reverse(Stack<Integer>s)
    {
        if(s.size()==1)
        {
            return ;
        }
        int temp = s.pop();
        reverse(s);
        last(s,temp);
    }
    static void last(Stack<Integer>s , int temp)
    {
        if(s.size()==0)
        {
            s.push(temp);
            return;
        }
        int val = s.pop();
        last(s,temp);
        s.push(val);
    }
    public static void main(String args[])
    {
        Stack<Integer> s = new Stack<>();
        s.push(65);
        s.push(89);
        s.push(98);
        s.push(68);
        s.push(41);
        s.push(8);

        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}