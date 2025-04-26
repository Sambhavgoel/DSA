import java.util.*;
class Digitinc{
    private static void solve(int start, int n , ArrayList<Integer>temp,ArrayList<Integer>ans)
    {
        if(start==(n))
        {
            System.out.println(temp);
            int sol=0;
            for(int ele : temp)
            {
                sol=(sol*10)+ele;
            }
            ans.add(sol);
            return;
        }
        if(start==0)
        {
            for(int i=0;i<=9;i++)
            {
                temp.add(i);
                solve(start+1,n,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
        else if(start<n)
        {
            for(int i=1;i<=9;i++)
            {
                if(i>temp.get(temp.size()-1))
                {
                    temp.add(i);
                    solve(start+1,n,temp,ans);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner (System.in);
        int n = sc.nextInt();
        ArrayList<Integer> temp = new ArrayList<>();
        int start=0;
        ArrayList<Integer> ans = new ArrayList<>();
        solve(start,n,temp,ans);
        // System.out.println(ans);
    }
}