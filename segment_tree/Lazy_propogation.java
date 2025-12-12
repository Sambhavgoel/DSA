import java.util.*;

public class Lazy_propogation {
    public static void lazyupdate(int first,int second,int val,int left, int right , int idx, ArrayList<Integer>tree,ArrayList<Integer>lazy)
    {
        if(lazy.get(idx)!=0)
        {
            tree.set(idx,tree.get(idx)+((right-left+1)*lazy.get(idx)));
            if(left!=right)
            {
                lazy.set((2*idx+1),lazy.get(2*idx+1)+lazy.get(idx));
                lazy.set((2*idx+2),lazy.get(2*idx+2)+lazy.get(idx));
            }
            lazy.set(idx,0);
        }
        if(left>second||right<first)return;
        if(first<=left && right<=second)
        {
            tree.set(idx,tree.get(idx)+(right-left+1)*val);
            if(left!=right)
            {
                lazy.set(2*idx+1,lazy.get(2*idx+1)+val);
                lazy.set(2*idx+2,lazy.get(2*idx+2)+val);
            }
            return;
        }

        int mid = (left+(right-left)/2);

        lazyupdate(first, second, val, left, mid, (2*idx+1), tree, lazy);
        lazyupdate(first, second, val, mid+1, right, (2*idx+2), tree, lazy);

        tree.set(idx,tree.get(2*idx+1)+tree.get(2*idx+2));

    }
    
    public static void main(String args[])
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 6 };
        int n = arr.length;
        ArrayList<Integer> tree = new ArrayList<>(Collections.nCopies(4 * n, 0));
        ArrayList<Integer> lazy = new ArrayList<>(Collections.nCopies(4 * n, 0));

        int range_first = 3;
        int range_second = 7;
        int val = 3;

        lazyupdate(range_first,range_second,val,0,n-1,0,tree,lazy);
    }

}
