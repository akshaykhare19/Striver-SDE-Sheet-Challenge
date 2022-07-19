/*
 * Next Greater Element I
Easy

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

 

Constraints:

    1 <= nums1.length <= nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 104
    All integers in nums1 and nums2 are unique.
    All the integers of nums1 also appear in nums2.

 
Follow up: Could you find an O(nums1.length + nums2.length) solution?
Accepted
394,608
Submissions
557,846
 */
import java.util.*;
public class NextGreaterElement
{
    //TC - O(n^2)
    //SC - O(1)
    private static int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
        for(int i = 0; i < nums1.length; i++){
            int e = nums1[i];
            int j;
            for(j = 0; j < nums2.length; j++){
                if(nums2[j]==e){
                    j++;
                    while(j<nums2.length && nums2[j]<=e) j++;
                    if(j!=nums2.length) nums1[i] = nums2[j];
                    else nums1[i] = -1;
                    break;
                }
            }
        }
        return nums1;
    }

    //TC - O(n)
    //SC - O(n)
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        st.push(nums2[n-1]);
        map.put(nums2[n-1], -1);
        
        // System.out.println(map);
        for(int i = n-2; i >= 0; i--){
            // System.out.println(nums2[i]);
            while(st.size()>0 && st.peek()<=nums2[i]) st.pop();
            // System.out.println(map);
            if(st.size()>0){
                map.put(nums2[i], st.peek());
                st.push(nums2[i]);
                // System.out.println(map);
            }
            else{
                map.put(nums2[i], -1);
                st.push(nums2[i]);
            }
            // System.out.println(map);
        }
        
        for(int i = 0; i < m; i++){
            if(map.containsKey(nums1[i])){
                nums1[i] = map.get(nums1[i]);
            }
        }
        // System.out.println(map);
        return nums1;
    }

    private static void display(int a[]){
        for(int i : a) System.out.print(i + " ");
    }

    public static void main(String args[])
    {
        int nums1[] = {4,1,2};
        int nums2[] = {1,3,4,2};
        display(nextGreaterElementBrute(nums1, nums2));
        System.out.println();
        int a[] = {4,1,2};
        int b[] = {1,3,4,2};
        display(nextGreaterElement(a, b));
    }    
}
