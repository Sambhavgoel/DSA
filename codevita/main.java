import java.util.*;
class main{
    private static void solve(String binary,int a,int b,ArrayList<Integer>arr)
    {
        int zero=0;
        int one = 0;
        int zeroone=0;
        int onezero=0;

        for(int i=0;i<binary.length();i++)
        {
            if(binary.charAt(i)=='0')
            {
                zero++;
            }
            else if(binary.charAt(i)=='1'){
                one++;
            }
            else{
                System.out.println("INVALID");
                return;
            }
            if(i>0)
            {
                if(binary.charAt(i)=='0' && binary.charAt(i-1)=='1')
                {
                    onezero++;
                }
                else if(binary.charAt(i)=='1' && binary.charAt(i-1)=='0')
                {
                    zeroone++;
                }
            }
        }
       
        int currcost = (a*(zeroone))+(b*(onezero));
        int newcost = 0;
        if(a>b)
        {
            newcost = b;
        }
        else{
            newcost = a;
        }
        if(newcost<=currcost)
        {
           
            arr.add(newcost);
        }
        else{
            
            arr.add(currcost);
        }
    }
    public static void main(String args[])
    {
      	
        Scanner sc = new Scanner(System.in);
        int testcs = sc.nextInt();
      	ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<testcs;i++)
        {
            String binary = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            solve(binary,a,b,arr);
          
        }
        for(int ele : arr){
            System.out.println(ele);
          }
    }
}