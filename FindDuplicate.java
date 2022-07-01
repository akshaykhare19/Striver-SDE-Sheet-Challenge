/*
 *  Find the Duplicate Number
Medium

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

 

Constraints:

    1 <= n <= 105
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one integer which appears two or more times.

 */
public class FindDuplicate
{
    //TC - O(n)
    //SC - O(1)
    private static int findDuplicate(int[] nums) {
        //Using cycle detection in linked list technique.
        //Using slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);
        
        //Now slow and fast are equal
        
        fast = nums[0];
        
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public static void main(String args[])
    {
        int a[] = {3,3,5,4,1,3};
        System.out.println(findDuplicate(a));
    }  
}
