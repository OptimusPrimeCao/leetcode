package Traverse;

public class SwapNodesInPairs {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode swapPairs(ListNode head) {
		ListNode p = head;
		ListNode q;
		ListNode pre = null;
		ListNode newHead = head;
		
		while(p != null && p.next != null) {
			q = p.next;
			if(pre == null)  
				newHead = q;
			else 
				pre.next = q;
			p.next = q.next;
			q.next = p;
			pre = p;
			p = p.next;	
		}
		
		return newHead;
	}
}
