/*
 *  Count Inversions
Difficulty: MEDIUM
Contributed By
Deep Mavani
|Level 1
Avg. time to solve
40 min
Success Rate
55%
Problem Statement
For a given integer array/list 'ARR' of size 'N' containing all distinct values, 
find the total number of 'Inversions' that may exist.
An inversion is defined for a pair of integers in the array/list 
when the following two conditions are met.

A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

1. 'ARR[i] > 'ARR[j]' 
2. 'i' < 'j'

Where 'i' and 'j' denote the indices ranging from [0, 'N').

Input format :

The first line of input contains an integer 'N', denoting the size of the array.

The second line of input contains 'N' integers separated by a single space, 
denoting the elements of the array 'ARR'.

Output format :

Print a single line containing a single integer that denotes the 
total count of inversions in the input array.

Note:

You are not required to print anything, it has been already taken care of. 
Just implement the given function.  

Constraints :

1 <= N <= 10^5 
1 <= ARR[i] <= 10^9

Where 'ARR[i]' denotes the array element at 'ith' index.

Time Limit: 1 sec

Sample Input 1 :

3
3 2 1

Sample Output 1 :

3

Explanation of Sample Output 1:

We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).

Sample Input 2 :

5
2 5 1 3 4

Sample Output 2 :

4

Explanation of Sample Output 1:

We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).


 */

public class CountInversions
{
    private static long getInversionsBrute(long arr[], int n) {
        // Write your code here.
        long cnt = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = n-1; j > i; j--){
                if(arr[i] > arr[j]) cnt++;
            }
        }
        return cnt;
    }

    private static long mergeTwoSortedArrays(long a[], long temp[], int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        int k = lo;
        long inv_cnt = 0;
        
        while(i <= mid && j <= hi){
            if(a[i] > a[j]){
                inv_cnt += (mid-i+1);
                temp[k++] = a[j++];
            }
            else{
                temp[k++] = a[i++];
            }
        }
        
        while(i <= mid){
            temp[k++] = a[i++];
        }
        
        while(j <= hi){
            temp[k++] = a[j++];
        }
        
        for(i = lo; i <= hi; i++){
            a[i] = temp[i];
        }
        
        return inv_cnt;
    }
    
    private static long mergeSort(long a[], long temp[], int lo, int hi) {
        int mid; 
        long inv_cnt = 0;
        if(lo < hi){
            mid = (lo+hi)/2;
            
            inv_cnt += mergeSort(a, temp, lo, mid);
            inv_cnt += mergeSort(a, temp, mid+1, hi);
            
            inv_cnt += mergeTwoSortedArrays(a, temp, lo, mid, hi);
        }
        return inv_cnt;
    }
    
    private static long getInversionsOptimal(long arr[], int n) {
        // Write your code here.
        long temp[] = new long[n];
        return mergeSort(arr, temp, 0, n-1);
    }

    public static void main(String args[])
    {
        int n = 5;
        long a[] = {5,4,3,2,1};
        System.out.println("Brute : " + getInversionsBrute(a, n));
        System.out.println("Optimal : " + getInversionsOptimal(a, n));
    }
}
