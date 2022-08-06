/*
 *  Permutation Sequence
Hard

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:

Input: n = 4, k = 9
Output: "2314"

Example 3:

Input: n = 3, k = 1
Output: "123"

 

Constraints:

    1 <= n <= 9
    1 <= k <= n!

Accepted
288,458
Submissions
669,755
 */

import java.util.*;
public class KthPermutationSequence
{
    //TC - O(N^2), N for traversing the list and N for removing an elment everytime
    //SC - O(N)
    private static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        
        //Since we choose 1 element and try to find permutations of n-1 numbers, which are total (n-1)!
        for(int i = 1; i < n; i++){
            fact*=i;
            numbers.add(i);
        }
        numbers.add(n);
        
        //Since list stores data in 0-based indices, kth permutation will be stores at (k-1)th index
        k--;
        String ans = "";
        while(true){
            int idx = k/fact;
            int num = numbers.get(idx);
            numbers.remove(idx);
            ans+=num;
            if(numbers.size()==0) break;
            k%=fact;
            fact/=(numbers.size());
        }
        return ans;
    }

    public static void main(String args[])
    {
        int n = 4, k = 9;
        System.out.println(getPermutation(n, k));
    }    
}
