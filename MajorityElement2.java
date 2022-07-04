/*
 * Majority Element II
Medium

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]

Example 2:

Input: nums = [1]
Output: [1]

Example 3:

Input: nums = [1,2]
Output: [1,2]

 

Constraints:

    1 <= nums.length <= 5 * 104
    -109 <= nums[i] <= 109

 */

import java.util.*;
public class MajorityElement2
{
    //TC - O(n)
    //SC - O(1)
    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        int c1 = 0, c2 = 0, num1 = 0, num2 = 0;
        
        for(int ele : nums){
            if(num1==ele) c1++;
            
            else if(num2==ele) c2++;
            
            else if(c1==0){
                num1 = ele;
                c1 = 1;
            } 
            
            else if(c2==0){
                num2 = ele;
                c2 = 1;
            }
            
            else{
                c1--;
                c2--;
            }
        }
        
        int cnt1 = 0, cnt2 = 0;
        for(int i : nums){
            if(i==num1) cnt1++;
            
            else if(i==num2) cnt2++;
        }
        
        if(cnt1>nums.length/3){
            ans.add(num1);
        }
        if(cnt2>nums.length/3){
            ans.add(num2);
        }
        return ans;
    }    

    public static void main(String args[])
    {
        int a[] = {3,2,3};
        System.out.println(majorityElement(a));
    }
}
