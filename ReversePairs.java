/*
 * Reverse Pairs
Hard

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2

Example 2:

Input: nums = [2,4,3,5,1]
Output: 3

 

Constraints:

    1 <= nums.length <= 5 * 104
    -231 <= nums[i] <= 231 - 1


 */

public class ReversePairs
{
    private static int reversePairs(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] > 2 * (long)nums[j]) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String args[])
    {
        int a[] = {1,3,2,3,1};
        System.out.println(reversePairs(a));
    }
}