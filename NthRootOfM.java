/*
 *  Nth Root Of M
Difficulty: EASY
Contributed By
Anish De
|Level 1
Avg. time to solve
10 min
Success Rate
90%
Problem Statement
You are given two positive integers N and M. You have to find the Nth root of M i.e. M^(1/N).
Note:

N'th root of an integer M is a real number, which when raised to the power N gives M as a result.

N'th root of the M should be correct up to 6 decimal places.

Input Format:

The first line of the input contains an integer T denoting the number of test cases.

The first and only line of each test case consists of two space-separated integers N and M.

Output Format:

For each test case, print a real number with precision till 6 decimal places that denote the Nth root of M in a separate line.

Note:

You don't have to print anything, it has already been taken care of. Just Implement the given function.

Constraints:

1<= T <= 10^3
1<= N <= 300
1<= M <= 10^15

Time Limit: 1 sec.

Sample Input 1:

1
3 27

Sample Output 1:

3.000000

Explanation For Sample Input 1:

3rd Root of 27 is 3.000000, as (3.000000)^3 is equal to 27.

Sample Input 2:

1
4 69

Sample Output 2:

2.882121


 */


public class NthRootOfM
{
    static double multiply(double num, int n){
        double ans = 1.0;
        for(int i = 1; i <= n; i++){
            ans *= num;
        }
        return ans;
    }
    

    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        double lo = 1, hi = m;
        double eps = 1e-6;
        while((hi-lo) > eps){
            double mid = (lo+hi)/2.0;
            
            if(multiply(mid, n)>m){
                hi = mid;
            }
            else lo = mid;
        }
        return lo;
    }

    public static void main(String args[])
    {
        int n = 3;
        long m = 27;

        //Approach 1
        System.out.println( Math.pow(m, 1/(double)n));

        //Approach 2 
        //TC - n*log2(m*10^d), where d is the number of digits after decimal in the answer
        System.out.println(findNthRootOfM(n, m));
    }    
}
