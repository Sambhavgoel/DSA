import java.util.*;
class sjf{
    public static void avg(int[]jobs)
    {
        Arrays.sort(jobs);
        int time=0,wait=0;
        for(int i=0;i<jobs.length;i++)
        {
            wait+=time;
            time+=jobs[i];
        }
        System.out.println("avg : "+wait/jobs.length);
    }
    public static void main(String args[])
    {
        int[] jobs = {4, 3, 7, 1, 2};
        avg(jobs);
    }
}