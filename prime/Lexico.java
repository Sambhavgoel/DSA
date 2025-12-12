import java.util.*;
public class Lexico {
    public static void cal(char[]arr, String op, int idx,List<String>ans)
    {
        if(op!="")
        {
            ans.add(op);
        }
        if(op.length()==3)
        {
            // ans.add(op);
            return;
        }
        
        for(int i=0;i<3;i++)
        {
            cal(arr,op+arr[i],idx+1,ans);
        }
    }
    public static void main(String args[])
    {
        char[]arr  = {'a','b','c'};
        String op="";
        List<String>ans = new ArrayList<>();
        cal(arr,op,0,ans);
        for(String i:ans)
        {
            System.out.println(i);
        }

    }

}
