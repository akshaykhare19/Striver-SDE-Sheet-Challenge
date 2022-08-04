/*
 * Subsets II
Medium

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

 

Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10

Accepted
562,882
Submissions
1,033,411
 */

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
