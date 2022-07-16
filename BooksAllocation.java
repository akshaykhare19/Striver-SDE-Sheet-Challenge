/*
 * Allocate Books
medium
Asked In:
Google
Flipkart

Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.




Input Format

The first argument given is the integer array A.
The second argument given is the integer B.

Output Format

Return that minimum possible number

Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^5

For Example

Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion : 
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100

Note:You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a question? Checkout Sample Codes for more details.
submission-count
39992successful submissions.
 */

import java.util.*;
public class BooksAllocation
{
    static int maxInArray(ArrayList<Integer> al){
        int max = 0;
        for(int n : al)
            max = Math.max(n, max);
        return max;
    }
    
    static int sumOfArray(ArrayList<Integer> al){
        int sum = 0;
        for(int n : al)
            sum+=n;
        return sum;
    }
    
    static boolean isFeasible(ArrayList<Integer> al, int barrier, int k){
        int pages = 0, student = 1;
        for(int n : al){
            if(pages + n > barrier){
                student++;
                pages = n;
            }
            else{
                pages+=n;
            }
        }
        return student<=k;
    }
    
    private static int books(ArrayList<Integer> A, int B) {
        if(B > A.size()) return -1;
        
        
        int min = maxInArray(A);
        int max = sumOfArray(A);
        int res = -1;
        // System.out.println("Search space is from "+ min + " to " + max);
        
        while(min<=max){
            int mid = (min+max)>>1;
            if(isFeasible(A, mid, B)){
                res = mid;
                max = mid-1;
            }
            else min = mid+1;
        }
        
        return res;
    }   

    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(10);
        al.add(20);
        al.add(30);
        
        int k = 2;

        System.out.println(books(al, k));
    }

}
