/*
 * Reverse Nodes in k-Group
Hard

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 

Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 5000
    0 <= Node.val <= 1000

 

Follow-up: Can you solve the problem in O(1) extra memory space?
Accepted
560,166
Submissions
1,070,860
 */

public class ReverseKNodes
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

    private int size(ListNode head) {
        int len = 0;
        ListNode ptr = head;
        while(ptr!=null){
            len++;
            ptr = ptr.next;
        }
        return len;
    }
    
    //TC - O(n)
    //SC - O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        
        int len = size(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr, forw;
        while(len>=k)
        {
            curr = pre.next;
            forw = curr.next;

            for(int i = 1; i < k; i++)
            {
                curr.next = forw.next;
                forw.next = pre.next;
                pre.next = forw;
                forw = curr.next;
            }
            pre = curr;
            len-=k;
        }
        return dummy.next;
    }  
}
