/*
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

 

Constraints:

    -100.0 < x < 100.0
    -231 <= n <= 231-1
    -104 <= xn <= 104


 */

public class PowerXtoN
{   
    //TC - O(n)
    //SC - O(1)
    private static double brute(double x, int n) {
        if(n==0) return 1.0;
        long nn = n;
        if(n<0) nn *= -1;
        double ans = 1.0;
        for(int i = 1; i <= nn; i++){
            if(n<0) ans = ans / x;
            else ans = ans * x;
        }
        return ans;
    }

    //TC - O(logn)
    //SC - O(1)
    private static double optimal(double x, int n) {
        if(n==0) return 1.0;
        long nn = n;
        if(nn<0) nn *= -1;
        double ans = 1.0;
        while(nn>0){
            if(nn%2==0){
                x = x * x;
                nn /= 2;
            }
            else{
                ans = ans * x;
                nn--;
            }
        }
        if(n<0) return (double)1.0/ans;
        return ans;
    }

    public static void main(String args[])
    {
        System.out.println("Brute : " + brute(2.0, 4));
        System.out.println("Optimal : " + optimal(2.0, 4));
    }    
}
