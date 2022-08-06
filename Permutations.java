/*
 * Permutations
Medium

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

 

Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.

Accepted
1,286,826
Submissions
1,745,988
 */

import java.util.*;
public class Permutations
{
    //TC - O(N! * N)
    //SC - O(N) + O(N)
    private static void permute(int a[], List<Integer> ds, List<List<Integer>> ans, boolean freq[]){
        if(ds.size()==a.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i < a.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(a[i]);
                permute(a, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
        
    }
    
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        permute(nums, new ArrayList<>(), ans, freq);
        return ans;
    }

    public static void main(String args[])
    {
        int nums[] = {1,2,3};
        System.out.println(permute(nums));
    }    
}
