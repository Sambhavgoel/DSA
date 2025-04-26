public class backspaceStringCmp {
    public static String build(String s)
    {
        StringBuilder temp = new StringBuilder();
        int n = s.length();
        int i=0;
        while(i<n)
        {
            if(s.charAt(i)!='#')
            {
                temp.append(s.charAt(i));
            }
            else if(temp.length()>0){
                temp.deleteCharAt(temp.length()-1);
            }
            i++;
        }
        return temp.toString();
    }
    public static void main(String args[]) {
        String s = "ab#c";
        String t = "ad#c";
        String s1 = build(s);
        String t1 = build(t);
        System.out.println(s1);
        System.out.println(t1);
        System.out.println(s1.equals(t1));
        
    }
}