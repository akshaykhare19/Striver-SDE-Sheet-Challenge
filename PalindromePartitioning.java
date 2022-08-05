/*
 *  Palindrome Partitioning
Medium

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]

 

Constraints:

    1 <= s.length <= 16
    s contains only lowercase English letters.

Accepted
495,759
Submissions
810,287
 */

import java.util.*;
public class PalindromePartitioning
{
    private static void helper(String str, int idx, List<String> ds, List<List<String>> ans) {
        if(idx==str.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = idx; i < str.length(); i++){
            int startIdx = idx;
            int endIdx = i;
            if(isPalindrome(str, startIdx, endIdx)){
                ds.add(str.substring(startIdx, endIdx+1));
                helper(str, i+1, ds, ans);
                ds.remove(ds.size()-1);
            }
        }   
    }
    
    private static boolean isPalindrome(String s, int startIdx, int endIdx) {
        while(startIdx<=endIdx){
            char start = s.charAt(startIdx);
            char end = s.charAt(endIdx);
            if(start!=end) return false;
            startIdx++;
            endIdx--;
        }
        return true;
    }
    
    private static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String args[])
    {
        String str = "aabb";
        System.out.println(partition(str));
    }    
}
