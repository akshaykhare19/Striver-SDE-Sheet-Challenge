/*
 * Merge Sorted Array
Easy

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, 
but instead be stored inside the array nums1. To accommodate this, 
nums1 has a length of m + n, where the first m elements denote the elements 
that should be merged, and the last n elements are set to 0 and should be ignored.
nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. 
The 0 is only there to ensure the merge result can fit in nums1.

 

Constraints:

    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109

 */

public class MergeSorted
{
    /*
     * Approach 1 : 
     * Create a new array of size m+n and traverse both arrays A and B and
     * whichever array has a smaller element place it in the new array and
     * move that array's pointer to next index.
     * TC - O(m+n)
     * SC - O(m+n)
     */

    //Approach 2
    //TC - O(m+n)
    //SC - O(m+n)
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n==0) return;
        for(int i = 0; i < m; i++){
            if(nums1[i] > nums2[0]){
                int t = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = t;
            }
            int first = nums2[0];
            int k;
            for (k = 1; k < n && nums2[k] < first; k++) {
                nums2[k - 1] = nums2[k];
            }
            nums2[k - 1] = first;
        }
        
        int i = m, j = 0;
        while(i < m+n){
            nums1[i++] = nums2[j++];
        }
    }

    private static void display(int a[])
    {
        for(int i : a)
        {
            System.out.print(i + " ");
        }
    }

    public static void main(String args[])
    {
        int m = 3;
        int n = 3;
        int a[] = new int[m+n];
        a[0] = 1;
        a[1] = 2;
        a[2] = 10;
        display(a);
        System.out.println();

        int b[] = new int[n];
        b[0] = 2;
        b[1] = 5;
        b[2] = 9;
        display(b);
        System.out.println();

        merge(a, m, b, n);
        display(a);

    }    
}
