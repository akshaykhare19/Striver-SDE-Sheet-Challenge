package Arrays;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

 

Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1

 */

public class SetMatrixZeroes
{
    //TC - O(m*n * (m+n))
    //SC - O(1)
    public static void bruteSetZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]==0){
                    
                    //row
                    int rowConst = i;
                    int col = 0;
                    while(col < n){
                        if(matrix[rowConst][col]!=0){
                            matrix[rowConst][col] = -1;
                        }
                        col++;
                    }
                    
                    //column
                    int colConst = j;
                    int row = 0;
                    while(row < m){
                        if(matrix[row][colConst]!=0){
                            matrix[row][colConst] = -1;
                        }
                        row++;
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //TC - O(n*m)
    //SC - O(n+m)
    public static void betterSetZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dummyRow[] = new int[m];
        int dummyCol[] = new int[n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]==0){
                    dummyRow[i] = -1;
                    dummyCol[j] = -1;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dummyRow[i]==-1 || dummyCol[j]==-1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        bruteSetZeroes(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

