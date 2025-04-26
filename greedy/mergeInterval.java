import java.util.*;
class mergeInterval{
    public static void merge(int[][]intervals)
    {
        ArrayList<int[]>res = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i=0;i<n;i++)
        {
            if(intervals[i][0]<=end)
            {
                end = Math.max(intervals[i][1],end);
            }
            else{
                res.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start,end});
        for(int[] i : res)
        {
            System.out.println(i[0]+" "+i[1]);
        }
    }
    public static void main(String args[])
    {
        int[][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }
}