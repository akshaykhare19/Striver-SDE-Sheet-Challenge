/*
 * Median of Two Sorted Arrays
Hard

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 

Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106

Accepted
1,475,974
Submissions
4,271,735
 */

public class MedianOfTwoSortedArrays
{
    //TC - O(m+n), where m and n are the lengths of the arrays nums1 and nums2
    //SC - O(m+n)
    private static double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length+nums2.length];
        int i = 0, j = 0, k = 0;
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                ans[k] = nums1[i];
                i++;
            }
            else{
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i<nums1.length){
            ans[k++] = nums1[i++];
        }
        
        while(j<nums2.length){
            ans[k++] = nums2[j++];
        }
        
        int n = ans.length;
        if((n&1)==0){
            int mid1 = (n>>1)-1;
            int mid2 = n>>1;
            return (ans[mid1]+ans[mid2])/2.0;
        }
        return ans[n>>1];
        
    }
    
    public static void main(String args[])
    {
        int a[] = {1,3};
        int b[] = {2,4};
        System.out.println(findMedianSortedArraysBrute(a, b));
    }    
}
