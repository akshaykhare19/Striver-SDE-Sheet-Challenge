/*
 * Add Two Numbers
Medium

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 

Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros
 */

public class AddTwoNumberLL
{
    public static class ListNode
    {
        int val;
        ListNode next;
        
        ListNode() {}

        ListNode(int val)
        {
            this.val = val;
        }

        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode t1, ListNode t2) {
        
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        
        int carry = 0;
        while(t1!=null && t2!=null){
            int sum = t1.val + t2.val + carry;
            int pv = sum%10;
            carry = sum/10;
            //add pv to new linkedlist
            ListNode nn = new ListNode(pv);
            temp.next = nn;
            temp = nn;
            
            t1 = t1.next;
            t2 = t2.next;
        }
        
        while(t1!=null){
            int sum = t1.val + carry;
            int pv = sum%10;
            //add pv to ll
            ListNode nn = new ListNode(pv);
            temp.next = nn;
            temp = nn;
            
            t1 = t1.next;
        }
        
        while(t2!=null){
            int sum = t2.val + carry;
            int pv = sum%10;
            //add pv to ll
            ListNode nn = new ListNode(pv);
            temp.next = nn;
            temp = nn;
            
            t2 = t2.next;   
        }
        
        if(carry!=0){
            ListNode nn = new ListNode(carry);
            temp.next = nn;
            temp = nn;
        }   
        
        return ans.next;
        
    }
}
