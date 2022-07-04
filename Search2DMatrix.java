/*
 * Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

 

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104


 */

public class Search2DMatrix
{
    //TC - O(m*n)
    //SC - O(1)
    private static boolean brute(int a[][], int t)
    {
        for(int[] i : a){
            for(int j : i){
                if(j==t) return true;
            }
        }
        return false;
    }

    //TC - O(mlogn)
    //SC - O(1)
    private static boolean better(int a[][], int t)
    {
        int m = a.length;
        int n = a[0].length;

        for(int i = 0; i < m; i++){
            int l = i, r = n-1;
            while(l <= r){
                int mid = (l+r)/2;
                if(a[i][mid]==t) return true;

                else if(a[i][mid] > t) r = mid-1;

                else l = mid+1;
            }
        }
        return false;
    }

    //TC - O(m+n)
    //SC - O(1)
    private static boolean muchBetter(int a[][], int t)
    {
        int m = a.length;
        int n = a[0].length;

        int i = 0, j = n-1;
        while(i < m && j >= 0){
            if(a[i][j]==t) return true;

            else if(a[i][j] > t) j--;

            else i++;
        }
        return false;
    }

    //TC - O(log(m*n))
    //SC - O(1)
    private static boolean optimal(int a[][], int t)
    {
        int m = a.length;       //no. of rows
        int n = a[0].length;    //no. of columns

        int totalEle = m*n;
        int l = 0, r = totalEle-1;

        while(l <= r){
            int mid = (l+r)/2;

            int x = mid/n;
            int y = mid%n;

            if(a[x][y]==t) return true;

            else if(a[x][y] > t) r = mid-1;

            else l = mid+1;
        }
        return false;
    }

    public static void main(String args[])
    {
        int a[][] = {{10,11,12,13},{14,15,16,17},{21,31,41,51}};
        int t = 17;
        System.out.println("Brute : " + brute(a, t));
        System.out.println("Better : " + better(a, t));
        System.out.println("muchBetter : " + muchBetter(a, t));
        System.out.println("Optimal : " + optimal(a, t));
    }
}