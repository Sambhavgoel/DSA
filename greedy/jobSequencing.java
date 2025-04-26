import java.util.*;
class Job{
    int id;
    int deadline;
    int profit;
    Job(int id,int deadline,int profit)
    {
        this.id = id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
class Comp implements Comparator<Job>
{
    @Override
    public int compare(Job a,Job b)
    {
        if(a.profit>b.profit)return -1;
        else if(a.profit<b.profit)return 1;
        else return 0;
    }
}
class jobSequencing{
    public static void maxprofit(Job[]arr)
    {
        Arrays.sort(arr,new Comp());
        int n = arr.length;
        int countjob=0;
        int countprofit=0;
        int max=-1 ;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,arr[i].deadline);
        }
        // System.out.println("Max : "+max);
        int[]jobarr = new int[max+1];
        Arrays.fill(jobarr,-1);
        for(int i=0;i<n;i++)
        {
            int j = arr[i].deadline;
            while(jobarr[j]!=-1 && jobarr[j]>=0)
            {
                j--;
            }
            if(j>0)
            {
                jobarr[j] = arr[i].id;
                countjob++;
                countprofit+= arr[i].profit;
            }
            else{
                break;
            }


            // for(int j=arr[i].deadline;j>0;j--)
            // {
            //     if(jobarr[j]==-1)
            //     {
            //         jobarr[j] = arr[i].id;
            //         countjob++;
            //         countprofit+= arr[i].profit;
            //         break;
            //     }
            // }
        }
        System.out.println("Total Job selected : "+countjob);
        System.out.println("Total profit : "+countprofit);
    }
    public static void main(String args[])
    {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        maxprofit(arr);
    }
}