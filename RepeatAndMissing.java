import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
Find Missing And Repeating
Medium Accuracy: 37.77% Submissions: 100k+ Points: 4

Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.

Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement()
which takes the array of integers arr and n as parameters and returns an array of integers of size 2 
denoting the answer ( The first index contains B and second index contains A.)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N
 */

public class RepeatAndMissing
{
    //TC - O(nlogn)
    //SC - O(1)
    private static ArrayList<Integer> brute(int a[])
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(a);
        for(int i = 0; i < a.length-1; i++){
            if(a[i]==a[i+1]){
                ans.add(a[i]);      //repeating
                ans.add(i+1);       //missing
                break;       
            }
        }
        return ans;
    }

    //TC - O(n)
    //SC - O(n)
    private static ArrayList<Integer> better(int a[])
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int aux[] = new int[a.length];

        for(int i = 0; i < a.length; i++){
            aux[a[i]-1]++;
        }

        for(int i = 0; i < aux.length; i++){
            if(aux[i]==2) ans.add(0, i+1);
            if(aux[i]==0) ans.add(i+1);
        }

        return ans;
    }

    //TC - O(n)
    //SC - O(1)
    private static ArrayList<Integer> optimal(int a[])
    {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < a.length; i++){
            int abs = Math.abs(a[i]);
            if(a[abs-1] < 0){
                ans.add(abs);
            }
            else{
                a[abs-1] *= -1;
            }
        }

        for(int i = 0; i < a.length; i++){
            if(a[i] > 0){
                ans.add(i+1);
                break;
            }
        }

        return ans;
    }

    public static void main(String args[])
    {
        int a[] = {1,4,2,4,5}; //1 2 4 4 5
        System.out.println("Brute : " + brute(a));
        System.out.println("Better : " + better(a));
        System.out.println("Optimal : " + optimal(a));
    }    
}
