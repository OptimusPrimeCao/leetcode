package twoPointers;

import twoPointers.RemoveDuplicatesFromSortedList.ListNode;

public class RemoveDuplicatesFromSortedListII {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode pre = null;
		ListNode newHead = null;
		
		if(head.next.val != head.val) {
			newHead = head;
			pre = head;
		}
		else {
			p = head.next;
		}
		while(p.next != null) {
			if(p.next.val != p.val)
				if(p.next.next == null || (p.next.next != null && p.next.next.val != p.next.val)) {
					if(pre != null)
						pre.next = p.next;
					else 
						newHead = p.next;
					pre = p.next;
				}
			
			p = p.next;

		}
		if(pre != null)
			pre.next = null;
		return newHead;

	}
}
