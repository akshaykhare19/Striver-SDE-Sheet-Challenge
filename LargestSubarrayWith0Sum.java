/*
 * 
Largest subarray with 0 sum
Easy Accuracy: 46.94% Submissions: 100k+ Points: 2
Lamp
This problem is part of GFG SDE Sheet. Click here to view more.  

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.

Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i
 */

import java.util.*;
public class LargestSubarrayWith0Sum
{
    private static int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr = 0, len = 0, l = 0;
        for(int i = 0; i < n; i++){
            curr+=arr[i];
            
            if(curr==0){
                l = i+1;
            }
            
            else if(map.containsKey(curr)){
                int j = map.get(curr)+1;
                l = i-j+1;
            }
            
            else map.put(curr, i);
            len = Math.max(len, l);
        }
        return len;
    }

    public static void main(String args[])
    {
        int a[] = {15,-2,2,-1,1,-15,4};
        System.out.println(maxLen(a, 7));
    }
}