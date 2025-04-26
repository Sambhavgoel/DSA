import java.util.*;
class lemonadeChange{
    public static boolean change(List<Integer>bills)
    {
        int n  = bills.size();
        int five=0;
        int ten=0;

        for(int i=0;i<n;i++)
        {
            if(bills.get(i)==5)
            {
                five++;
            }
            else if(bills.get(i)==10)
            {
                if(five>0)
                {
                    ten++;
                    five--;
                }
                else{
                    return false;
                }
            }
            else{
                if(five>=3)
                {
                    five=five-3;
                }
                else if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else{
                    return false;
                }
            }
            
        }
        return true;
    }
    public static void main(String args[])
    {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);

        boolean ans = change(bills);
        System.out.println(ans);
    }
}