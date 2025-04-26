import java.util.*;
public class Sortstack{
    static void sort(Stack<Integer> s)
    {
        if(s.size()==0)
        {
            return ;
        }
        int temp = s.pop();
        sort(s);
        right(s,temp);
       
    }
     static void right(Stack<Integer> s , int temp)
    {
        if(s.isEmpty() || s.peek()<temp )
        {
            s.push(temp);
            return;
        }
        int val = s.pop();
        right(s,temp);
        s.push(val);
        
        
    }
    public static void main(String args[])
    {
        Stack<Integer> s = new Stack<>();
        s.push(65);
        s.push(8);
        s.push(94);
        s.push(9);
        s.push(1);
        System.out.println(s);
        sort(s);
        System.out.println(s);
        

    }
}