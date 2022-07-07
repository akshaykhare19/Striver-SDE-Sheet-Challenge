/*
 * Two Sum
Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

 */

import java.util.*;

public class TwoSum
{
    private static int[] brute(int a[], int target)
    {
        int ans[] = new int[2];

        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i]+a[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    
    private static int[] better(int a[], int target)
    {
        int ans[] = new int[2];

        Arrays.sort(a);

        int l = 0, r = a.length-1;
        while(l < r){
            if(a[l] + a[r] == target){
                ans[0] = l;
                ans[1] = r;
                return ans;
            }
            else if(a[l] + a[r] > target) r--;

            else l++;
        }

        return ans;
    }
    
    private static int[] optimal(int a[], int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        
        for(int i = 0; i < a.length; i++){
            if(map.containsKey(target-a[i])){
                ans[0] = map.get(target-a[i]);
                ans[1] = i;
                return ans;
            }
            map.put(a[i], i);
        }
        return ans;

    }

    public static void main(String args[])
    {
        int a1[] = {3,2,1,5,4};
        int target1 = 3;
        int bruteAns[] = brute(a1, target1);
        System.out.println("Brute - (" + bruteAns[0] + ", " + bruteAns[1] + ")");
        
        int a2[] = {3,2,1,5,4};
        int target2 = 3;
        int betterAns[] = better(a2, target2);
        System.out.println("Better - (" + betterAns[0] + ", " + betterAns[1] + ")");
        
        int a3[] = {3,2,1,5,4};
        int target3 = 3;
        int optimalAns[] = optimal(a3, target3);
        System.out.println("Optimal - (" + optimalAns[0] + ", " + optimalAns[1] + ")");
    }    
}
