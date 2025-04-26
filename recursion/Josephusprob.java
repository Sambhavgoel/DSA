import java.util.*;
public class Josephusprob{
    private static void solve(ArrayList<Integer>al,int k,int index )
    {
        if(al.size()==1)
        {
            System.out.println(al.get(0));
            return;
        }
        index = (index+k)%(al.size());
        al.remove(index);
        solve(al,k,index);

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner (System.in);
        ArrayList<Integer>al = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i=0;i<n;i++)
        {
            al.add(i+1);
        }
        k=k-1;
        int index=0;
        System.out.println(al);
        solve(al, k, index);
    }
}