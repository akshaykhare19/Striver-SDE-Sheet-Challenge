/*
 * Kth Largest Element in an Array
Medium

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 

Constraints:

    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104

Accepted
1,459,323
Submissions
2,245,223
 */

import java.util.*;

public class KthLargest
{
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        while(pq.size()<k){
            pq.add(nums[i++]);
        }
        
        while(i < nums.length){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
        return pq.peek();
    }

    public static void main(String args[])
    {
        int a[] = {4,2,1,6,2,4,8};
        int k = 4;
        System.out.println(findKthLargest(a, k));
    }
}