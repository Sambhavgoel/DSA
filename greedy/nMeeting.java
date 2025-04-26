import java.util.*;
class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start,int end,int pos)
    {
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class Comp implements Comparator<Meeting>
{
    @Override
    public int compare(Meeting a,Meeting b)
    {
        if(a.end<b.end)return -1;
        else if(a.end>b.end)return 1;
        else if(a.pos<b.pos)return -1;
        else return 1;
    }
}
class nMeeting{
    
    public static int meeting(int[]start,int[]end,int pos)
    {
        int n = start.length;
        ArrayList<Meeting>arr = new ArrayList<>();
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr.add(new Meeting(start[i],end[i],i+1));
        }
        Collections.sort(arr,new Comp());
        int freetime=arr.get(0).end;
        ans.add(arr.get(0).pos);
        int count=1;
        for(int i=1;i<n;i++)
        {
            if(arr.get(i).start>freetime)
            {
                freetime = arr.get(i).end;
                count++;
                ans.add(arr.get(i).pos);
            }
        }
        for(int i : ans)
        {
            System.out.print(i+" ");
        }
        return count;

    }
    public static void main(String args[])
    {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};

        int count=meeting(start,end,n);
        System.out.println("count : "+count);
    }
}