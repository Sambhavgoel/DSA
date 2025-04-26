import java.util.*;
class possiblesum{
    public Boolean totsum (int n , List<Integer>list , HashMap<Integer,Boolean>memo)
    {
        if(n==0)
        {
            return true;
        }
        if(n<0)
        {
            return false;
        }

        if(memo.containsKey(n))
        {
            return memo.get(n);
        }

        for(int num : list)
        {
            int sub = n-num;
            if(totsum(sub,list,memo))
            {
                memo.put(n,true);
                return true;
            }
        }
        memo.put(n,false);
        return false;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the number of elements :  ");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>(n);
        System.out.println("Enter the elements in List : ");
        
        for (int i=0; i<n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Enter the sum you want to find : ");
        int sum = sc.nextInt();

        possiblesum cal = new possiblesum();

        Boolean res = cal.totsum(sum , list, new HashMap<>());

        System.out.println("The possibility of sum is : "+res);
        
    }
}