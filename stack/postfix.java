import java.util.*;
class postfix{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<str.length();i++)
        {
            // int x = str.charAt(i);
            char j = str.charAt(i);
            if(j =='+'|| j =='-' || j =='*'|| j =='/'||j =='^')
            {
                int sum=0;
                int a = st.pop();
                int b = st.pop();
                if(j =='+')
                {
                    sum=a+b;
                }
                else if(j =='-')
                {
                    sum=a-b;
                }
                else if(j =='*')
                {
                    sum=a*b;
                }
                else if(j =='/')
                {
                    sum=a/b;
                }
                else 
                {
                    sum=(int)Math.pow(b,a);
                }
                st.push(sum);

            }
            else{
                int h=j;
                st.push(h);
            }
        }
        System.out.println(st.peek());
    }
}