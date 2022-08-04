/*
 * Combination Sum
Medium

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

 

Constraints:

    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500

Accepted
1,194,725
Submissions
1,791,078
 */

import java.util.*;
public class CombinationSum
{
    //TC - O(k * 2^t), where t is the target and k is the average size of ds 
    //SC - O(k * x), where x is the no. of combinations i.e. variable space complexity
    private static void uniqueCombinations(int a[], int i, int t, List<Integer> ds, List<List<Integer>> ans) {
        if(i==a.length){
            if(t==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(t<0) return;
        
        ds.add(a[i]);
        uniqueCombinations(a, i, t-a[i], ds, ans);      //take, can have repeated nos., so not increasing index
        
        ds.remove(ds.size()-1);
        uniqueCombinations(a, i+1, t, ds, ans);    //not take
        
    }
    
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        uniqueCombinations(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String args[])
    {
        int a[] = {1,5};
        int target = 10;
        System.out.println(combinationSum(a, target));
    }    
}
