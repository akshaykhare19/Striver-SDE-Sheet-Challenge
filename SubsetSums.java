/*
 * 
Subset Sums
Basic Accuracy: 56.36% Submissions: 30747 Points: 1

Given a list arr of N integers, print sums of all subsets in it.

 

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.

Example 2:

Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8

Your Task:  
You don't need to read input or print anything. Your task is to complete the function
subsetSums() which takes a list/vector and an integer N as an input parameter and return the
list/vector of all the subset sums.

Expected Time Complexity: O(2N)
Expected Auxiliary Space: O(2N)

Constraints:
1 <= N <= 15
0 <= arr[i] <= 104

 */
import java.util.*;
public class SubsetSums
{
    private static void subsetSums(ArrayList<Integer> arr, int idx, int n, int sum, ArrayList<Integer> ans){
        if(idx==n){
            // System.out.println(sum);
            ans.add(sum);
            return;
        }
        
        //take
        subsetSums(arr, idx+1, n, sum+arr.get(idx), ans);
        
        //not take
        subsetSums(arr, idx+1, n, sum, ans);
        

    }
    
    private static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSums(arr, 0, n, 0, ans);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String args[])
    {
        int n = 3;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(3);
        al.add(1);
        System.out.println(subsetSums(al, n));
    }
}