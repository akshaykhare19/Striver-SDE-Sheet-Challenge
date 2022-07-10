/*
 * Rotate List
Medium

Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

 

Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 109


 */

public class RotateLinkedList
{
    class Node
    {
	    int data;
	    Node next;
	    Node bottom;
        
	    Node(int d)
	    {
	    	data = d;
	    	next = null;
	    	bottom = null;
	    }
    }

    public ListNode rotate(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        while(curr.next!=null){
            prev = prev.next;
            curr = curr.next;
        }
        
        prev.next = null;
        curr.next = head;
        return curr;
        
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        ListNode ans = head;
        
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        
        if(size!=0) k=k%size;
        while(k-- > 0){
            ans = rotate(ans);
        }
        return ans;
    }
}