import java.util.*;
/*
 * Majority Element
Easy

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 

Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109

 */

public class MajorityElement 
{
    //TC - O(n^2)
    //SC - O(1)
    static int majorityElementBruteFinder(int a[])
    {
        int majEle = 0, maxCount = 0;
        for(int i = 0; i < a.length; i++)
        {
            majEle = a[i];
            int count = 0;
            for(int j = 0; j < a.length; j++)
            {
                if(a[j] == majEle) count++;
            }
            if(maxCount < count)
            {
                maxCount = count;
                majEle = a[i];
            }
            
        }
        if(maxCount > a.length/2) return majEle;
        return 0;
    }

    //TC - O(nlogn)
    //SC - O(1)
    static int majorityElementLittleOptimalFinder(int a[])
    {
        int maxCount = 0, count = 1, ans = 0;
        Arrays.sort(a);
        for(int i = 0; i < a.length-1; i++){
            if(a[i] == a[i+1]) count++;

            else {
                if(maxCount < count){
                    maxCount = count;
                    ans = a[i];
                }
                count = 1;
            }
        }
        if(maxCount > a.length/2){
            return ans;
        }
        return 0;
    }

    //TC - O(n){
    //SC - O(n)
    static int majorityElementOptimalFinder(int a[])
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < a.length; i++)
        {
            if(map.containsKey(a[i]))
            {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > a.length/2) return entry.getKey();
        }
        return 0;
    }

    //TC - O(n)
    //SC - O(1)
    static int majorityElementMostOptimalFinder(int a[])
    {
        int ans = a[0], priority = 1;
        for(int i = 1; i < a.length; i++)
        {
            if(a[i] == ans) priority++;

            else{
                priority--;
                if(priority == 0){
                    ans = a[i];
                    priority = 1;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == ans)
            {
                count++;
            }
        }
        if(count > a.length/2) return ans;
        return 0;
    }
    public static void main(String[] args)
    {
        int a[] = {1, 2, 2, 2, 1, 3, 2};
        System.out.println(majorityElementBruteFinder(a));
        System.out.println(majorityElementLittleOptimalFinder(a));
        System.out.println(majorityElementOptimalFinder(a));
        System.out.println(majorityElementMostOptimalFinder(a));
    }
}
