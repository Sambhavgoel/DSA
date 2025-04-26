import java.util.*;
class Numsubset {
    static void swap(int i,int j , int[]nums)
    {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    static void solve(int start,int[]nums,List<List<Integer>>ans)
    {
        if(start==(nums.length-1))
        {
            List<Integer>op = new ArrayList<Integer>();
            for(int i :nums)
            {
                op.add(i);
            }
            System.out.println(op);
            ans.add(op);
            return;
        }
        for(int i=start;i<nums.length;i++)
        {
            swap(start,i,nums);
            solve(start+1,nums,ans);
            swap(start,i,nums);
        }
    }
    // public static List<List<Integer>> permute(int[] nums) {
    //     int start=0;
    //     List<List<Integer>>ans = new ArrayList<>();
    //     solve(start,nums,ans);
    //     return ans;
    // }
    public static void permute(int[] nums) {
        int start=0;
        List<List<Integer>>ans = new ArrayList<>();
        solve(start,nums,ans);
        // return ans;
        return;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 0;
        int[] arr= new int[len];
        int i=0;
        while(n>0)
        {
            int num = n%10;
            arr[i]=num;
            i++;
            n=n/10;
        }
        permute(arr);
    }
}

// class Solution {
//     public List<List<Integer>> permute(int[] nums)
//     {
//         List<Integer> permute=new ArrayList<>();
//         List<List<Integer>> ans=new ArrayList<>();
//          solve(0,nums,permute,ans);
//          return ans;
//     }

//     public void solve(int ind, int[] nums, List<Integer> permute, List<List<Integer>> ans) {
//         if (ind == nums.length) {
//             ans.add(new ArrayList<>(permute));  // Add a copy of the current permutation to ans
//             return;
//         }

//         for (int i = 0; i <= permute.size(); i++) {
//             permute.add(i, nums[ind]);  // Insert the current number at index i
//             solve(ind + 1, nums, permute, ans);  // Recursively solve for the next element
//             permute.remove(i);  // Backtrack: remove the number and try the next possibility
//         }
//     }
// }