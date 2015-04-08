package twoPointers;

public class RotateList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n == 0)
			return head;
		int k = 0;
//		while(k < n && p != null) {
//			p = p.next;
//			k++;
//		}
//		if(p == null)
//			return head;
		
		ListNode p = head;
		while(p != null) {
			p = p.next;
			k++;
		}
		
		n = n % k;
		
		k = 0;
		p = head;
		while(k < n) {
			p = p.next;
			k++;
		}
		
		ListNode q = head;
		while(p.next != null) {
			q = q.next;
			p = p.next;
		}
		
		p.next = head;
		head = q.next;
		q.next = null;
		return head;
	}
}
