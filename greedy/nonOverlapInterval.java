import java.util.*;
class nonOverlapInterval{
    public static void overlap(int[][]intervals)
    {
        int n =intervals.length;
        Arrays.sort(intervals,Comparator.comparingInt(i->i[1]));
        int last = intervals[0][1];
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]>=last)
            {
                count++;
                last = intervals[i][1];
            }

        }
        System.out.println("Non overlapping intervals are : "+ (n-count));
    }
    public static void main(String args[])
    {
        // int[][]intervals = {{1,2},{2,3},{3,4},{1,3}};   // 1
        int[][]intervals = {{1,2},{1,2},{1,2}};   //2
        overlap(intervals); 
    }
}