import java.util.*;
/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]

 

Constraints:

    1 <= numRows <= 30


 */

public class PascalsTriangle
{
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalRes = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < numRows; i++){
            int ncr = 1;
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                list.add(ncr);
                ncr = ncr * (i-j) / (j+1);
            }
            finalRes.add(list);
        }
        return finalRes;
    }


    public static void main(String args[])
    {
        int numRows = 5;
        List<List<Integer>> list = generate(numRows);
        System.out.println(list);
    }
}
