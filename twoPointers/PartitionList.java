package twoPointers;


public class PartitionList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode partition(ListNode head, int x) {
		if(head == null)
			return head;
		ListNode largerHead = null;
		ListNode largerTail = null;
		ListNode smallerTail = null;
		ListNode smallerHead = null;

		ListNode p = head;
		while(p != null) {
			if(p.val >= x) {
				if(largerTail != null) 
					largerTail.next = p;
				else 
					largerHead = p;
				largerTail = p;
			}
			else {
				if(smallerTail != null) 
					smallerTail.next = p;
				else 
					smallerHead = p;
				smallerTail = p;
			}
			p = p.next;
		}
		if(smallerHead == null || largerHead == null)
			return head;

		smallerTail.next = largerHead;
		largerTail.next = null;
		return smallerHead; 
	}
}
