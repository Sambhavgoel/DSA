import java.util.*;
public class Delmideleinstack{
    static void delmid(Stack<Integer>s,int  k)
    {
        if(k==1)
        {
            s.pop();
            return ;
        }
        int temp = s.pop();
        delmid(s,k-1);
        s.push(temp);
    }
    public static void main(String args[])
    {
        Stack<Integer>s =new Stack<>();
        s.push(65);
        // s.push(89);
        s.push(98);
        s.push(68);
        s.push(41);
        s.push(8);

        int n = (s.size()/2)+1;
        System.out.println(s);
        System.out.println("The middle element that has to be delete is : "+n);
        delmid(s,n);
        System.out.println(s);
    }
}