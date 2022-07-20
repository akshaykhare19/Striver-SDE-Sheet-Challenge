/*
 * Nearest Smaller Element
easy
Asked In:
Amazon
Microsoft

Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]

Elements for which no smaller element exist, consider next smaller element as -1.

Input Format

The only argument given is integer array A.

Output Format

Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.

For Example

Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
Explaination 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
    
Input 2:
    A = [3, 2, 1]
Output 2:
    [-1, -1, -1]
Explaination 2:
    index 1: No element less than 3 in left of 3, G[1] = -1
    index 2: No element less than 2 in left of 2, G[2] = -1
    index 3: No element less than 1 in left of 1, G[3] = -1

 */

import java.util.*;
public class PrevSmaller
{
    private static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        
        st.push(A.get(0));
        A.set(0, -1);
        
        for(int i = 1; i < A.size(); i++){
            while(st.size()>0 && st.peek()>=A.get(i)) st.pop();
            if(st.size()==0) {
                int t = A.get(i);
                A.set(i, -1);
                st.push(t);
            }
            else{
                int t = A.get(i);
                A.set(i, st.peek());
                st.push(t);
            }
        }
        return A;
    }

    public static void main(String args[])
    {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(5);
        A.add(2);
        A.add(10);
        A.add(8);

        System.out.println(prevSmaller(A));
    }
}