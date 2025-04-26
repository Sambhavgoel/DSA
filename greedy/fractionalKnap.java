import java.util.*;
class Item{
    int weight;
    int value;
    Item(int value,int weight)
    {
        this.value=value;
        this.weight = weight;
    }
}
class Comp implements Comparator<Item>
{
    @Override
    public int compare(Item a,Item b)
    {
        double r1 = (double)a.value/(double)a.weight;
        double r2 = (double)b.value/(double)b.weight;

        if(r1>r2)return -1;
        else if(r2>r1)return 1;
        else return 0;
    }
}
class fractionalKnap{
    public static double fractional(Item[]item,int n , int W)
    {
        Arrays.sort(item,new Comp());
        double finalVal=0.0;
        int curWeight=0;
        for(int i=0;i<n;i++)
        {
            if(curWeight+item[i].weight<=W)
            {
                curWeight+=item[i].weight;
                finalVal+=item[i].value;

            }
            else{
                int remain = W-curWeight;
                finalVal+= ((double)item[i].value/(double)item[i].weight)*(double)remain;
                break;
            }
        }
        return finalVal;
    }
    public static void main(String args[])
    {
        Item[]item = {new Item(100,20),new Item(60,10),new Item(120,30)};
        int n=3;
        int W=50;
        double ans = fractional(item,n,W);
        System.out.println(ans);
    }
}