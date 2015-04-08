package twoPointers;

public class RemoveNthNodeFromEndOfList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n < 0 || head == null)
			return head;
		ListNode p = head;
		ListNode q = head;
		int k = 0;  //q前面有k个节点
		while(k <= n && q != null) {
			q = q.next;
			k++;
		}
		
		if(q == null && k!=n+1) {
			if(k == n)
				return head.next;
			else 
				return head;
		}
		
		while(q != null) {
			q = q.next;
			p = p.next;
		}
		ListNode temp = p.next.next;
		p.next = temp;
		return head;

	}
}
