/*
 * Valid Parentheses
Easy

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

 

Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

Accepted
2,437,206
Submissions
5,965,961
 */
import java.util.*;
public class ValidParanthesis
{
    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            i++;
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            
            else if(st.size()>0 && ch==')' && st.peek()=='(') st.pop();
            
            else if(st.size()>0 && ch=='}' && st.peek()=='{') st.pop();
            
            else if(st.size()>0 && ch==']' && st.peek()=='[') st.pop();
            
            else return false;
        }
        if(st.size()==0) return true;
        return false;
    }

    public static void main(String args[])
    {
        String s = "([])";
        System.out.println(isValid(s) ? "Valid" : "Invalid");
    }
}