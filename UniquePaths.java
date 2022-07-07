/*
 * Unique Paths
Medium

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

 */

public class UniquePaths
{
    //TC - O(2^n)
    //SC - O(2^n) Recursive Stack Space
    private static int uniquePathsHelper(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc) return 0;
        
        if(sr==dr && sc==dc) return 1;
        
        int rp = uniquePathsHelper(sr, sc+1, dr, dc);
        int dp = uniquePathsHelper(sr+1, sc, dr, dc);
        
        return rp+dp;
    }

    private static int uniquePathsOptimalHelper(int sr, int sc, int dr, int dc, int dp[][]) {
        if(sr > dr || sc > dc) return 0;

        if(sr==dr && sc==dc) return 1;

        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        dp[sr][sc] = uniquePathsOptimalHelper(sr, sc+1, dr, dc, dp) + uniquePathsOptimalHelper(sr+1, sc, dr, dc, dp);
        return dp[sr][sc];
    }
    
    
    private static int brute(int m, int n) {
        return uniquePathsHelper(0, 0, m-1, n-1);
    }

    private static int optimal(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        return uniquePathsOptimalHelper(0, 0, m-1, n-1, dp);
    }

    public static void main(String args[])
    {
        System.out.println("Brute : " + brute(4, 5));

        System.out.println("Optimal : " + optimal(4, 5));
    }    
}
