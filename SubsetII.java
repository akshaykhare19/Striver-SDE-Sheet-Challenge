import java.util.*;
public class SubsetII 
{    
    //TC - O(N * 2^N)
    //SC - O(2^N) + O(N)
    private static void subsets(int[] nums, int idx, int n, List<Integer> res, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(res));
        for(int i = idx; i < n; i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            res.add(nums[i]);
            subsets(nums, i+1, n, res, ans);
            res.remove(res.size()-1);
        }
    }
    
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        subsets(nums, 0, n, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String args[])
    {
        int nums[] = {4,4,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
