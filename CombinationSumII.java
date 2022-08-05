/*
 * Combination Sum II
Medium

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

 

Constraints:

    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30

Accepted
611,655
Submissions
1,155,899
 */

import java.util.*;
public class CombinationSumII
{
    //TC - O(k * 2^N), k is the average size of ds 
    //SC - O(k * x), where x is the no. of combinations i.e. variable space complexity
    private static void uniqueCombinations(int a[], int idx, int t, List<Integer> ds, List<List<Integer>> ans) {
        if(t<=0){
            if(t==0) ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = idx; i < a.length; i++){
            if(i!=idx && a[i]==a[i-1]) continue;
            ds.add(a[i]);
            uniqueCombinations(a, i+1, t-a[i], ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        uniqueCombinations(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String args[])
    {
        int a[] = {1,2,3,3,1};
        int target = 7;
        System.out.println(combinationSum2(a, target));
    }
}