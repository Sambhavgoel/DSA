import java.util.*;
public class RangeMaxIndexQuery {
    public static void buildtree(int idx, int left,int right, ArrayList<Integer>tree,int[]arr)
    {
        if(left==right)
        {
            tree.set(idx,left);
            return;
        }

        int mid = left+(right-left)/2;
        buildtree(2*idx+1,left,mid,tree,arr);
        buildtree(2*idx+2,mid+1,right,tree,arr);

        int leftIndexvalue = tree.get(2*idx+1);
        int rightIndexvalue = tree.get(2*idx+2);

        if(arr[leftIndexvalue]>=arr[rightIndexvalue])
        {
            tree.set(idx,leftIndexvalue);
        }
        else{
            tree.set(idx,rightIndexvalue);
        }


    }
    public static int query(int first,int second,int idx,int left,int right,ArrayList<Integer>tree,int[]arr)
    {
        if(left>second || right<first)return -1;
        if(first<=left&&right<=second)return tree.get(idx);

        int mid = left+(right-left)/2;
        int leftIndexvalue = query(first,second,2*idx+1,left,mid,tree,arr);
        int rightIndexvalue = query(first,second,2*idx+2,mid+1,right,tree,arr);

        if(leftIndexvalue==-1)return rightIndexvalue;
        if(rightIndexvalue==-1)return leftIndexvalue;


        if(arr[leftIndexvalue]>=arr[rightIndexvalue])
        {
            return leftIndexvalue;
        }
        return rightIndexvalue;
    }
    public static void main(String args[])
    {
        int[]arr = {2,4,6,7,6,4,8,4,8,5};
        int n = arr.length;
        ArrayList<Integer>tree = new ArrayList<>(Collections.nCopies(4*n,0));
        buildtree(0,0,n-1,tree,arr);

        int[]queries = {2,4,6,7,1,3};
        for(int i=0;i<queries.length;i=i+2)
        {
            int first = queries[i];
            int second = queries[i+1];
            int ans = query(first,second,0,0,n-1,tree,arr);
            System.out.println(ans);
        }
    }
}
