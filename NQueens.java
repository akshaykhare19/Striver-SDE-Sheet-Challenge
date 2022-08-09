/*
 * N-Queens
Hard

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:

Input: n = 1
Output: [["Q"]]

 

Constraints:

    1 <= n <= 9

Accepted
449,540
Submissions
728,917
 */

import java.util.*;
public class NQueens
{
    //TC - O(N! * N)
    //SC - O(N^2)
    private static void findNQueens(boolean chess[][], int row, List<String> ds, List<List<String>> ans) {
        if(row==chess.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int col = 0; col < chess[0].length; col++){
            chess[row][col] = true; //put the queen on (row,col)
            String rowStr = "";
            for(int i = 0; i < chess[0].length; i++){
                if(chess[row][i]) rowStr+="Q";
                else rowStr+=".";
            }
            ds.add(rowStr);
            if(isSafe(chess, row, col)){
                findNQueens(chess, row+1, ds, ans);    
            }
            ds.remove(ds.size()-1);
            chess[row][col] = false;
        }
        
    }
    
    private static boolean isSafe(boolean chess[][], int row, int col){
        //top-left diagonal
        int i = row-1, j = col-1;
        while(i>=0 && j>=0){
            if(chess[i][j]) return false;   //not safe
            i--;
            j--;
        }
        
        //top-right diagonal
        i = row-1;
        j = col+1;
        while(i>=0 && j<chess[0].length){
            if(chess[i][j]) return false;   //not safe
            i--;
            j++;
        }
        
        //top
        i = row-1;
        j = col;
        while(i>=0){
            if(chess[i][j]) return false;   //not safe
            i--;
        }
        return true;    //safe
    }
    
    private static List<List<String>> solveNQueens(int n) {
        boolean chess[][] = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        findNQueens(chess, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String args[])
    {
        int n = 4;
        System.out.println(solveNQueens(n));
    }    
}
