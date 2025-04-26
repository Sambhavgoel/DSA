import java.util.*;
class insertInterval{
    public static void merge(int[][]intervals,int[]newinterval)
    {
        ArrayList<int[]> res = new ArrayList<>();
        int n = intervals.length;
        if(n==0)
        {
            ans.add(newInterval);
        }
        for(int i=0;i<n;i++)
        {
            while(i<n && intervals[i][1]<newinterval[0])
            {
                res.add(intervals[i]);
            }
            while(i<n && intervals[i][0]<=newinterval[1])
            {
                newinterval[0] = Math.min(intervals[i][0],newinterval[0]);
                newinterval[1] = Math.max(intervals[i][1],newinterval[1]);
                i++;
            }
            res.add(newinterval);
            while(i<n && intervals[i][0]>newinterval[1])
            {
                res.add(intervals[i]);
                i++;
            }
        }
        for(int[] i : res)
        {
            System.out.println(i[0]+" "+i[1]);
        }
    }
    public static void main(String args[])
    {
        int[][]intervals = {{1,3},{6,9}};
        int[]newinterval = {2,5};
        merge(intervals,newinterval);
    }
}