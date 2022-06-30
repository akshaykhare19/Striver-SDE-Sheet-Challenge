/*
 * Maximum Subarray
Medium

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

 

Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

 */

public class SubarraySum
{
    //TC - O(n^2)
    //SC - O(1)
    public static int bruteLargestSubarraySum(int a[])
    {
        int n = a.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; j++)
            {
                sum += a[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    //TC - O(n)
    //SC - O(1)
    public static int kadaneAlgorithm(int a[])
    {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int maxEle = Integer.MIN_VALUE;
        // int startIdx = 0, endIdx = -1;
        for(int i = 0; i < a.length; i++)
        {
            // if(currSum == 0) startIdx = i;
            currSum += a[i];
            if(maxSum < currSum){
                maxSum = currSum;
                // endIdx = i;
            }
            if(currSum < 0) currSum = 0;
            
        }
        if(maxSum==0) maxSum = maxEle;
        // System.out.println("Start Index = " + startIdx + "\nEnd Index = " + endIdx);
        return maxSum;
    }

    public static void main(String args[])
    {
        int a[] = {-14, -15, -2, -3, -4, -8, -13};
        System.out.println(bruteLargestSubarraySum(a));
        System.out.println("Kadane's Algorithm");
        System.out.println(kadaneAlgorithm(a));
    }
}