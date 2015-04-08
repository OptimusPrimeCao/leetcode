package Sorting;

public class SortList2 {
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
		  }
		  }
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode p = head;
		ListNode q = head;
		
		while(q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
		}
		
		ListNode head1 = sortList(p.next);
		p.next = null;
		ListNode head2 = sortList(head);
		
		return merge(head1, head2);
			
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		ListNode head;
		if(head1.val < head2.val) {
			head = head1;
			head1 = head1.next;
		}
		else {
			head = head2;
			head2 = head2.next;
		}
		ListNode p = head;
		
		while(head1 != null && head2 != null) {
			if(head1.val < head2.val) {
				p.next = head1;
				p = head1;
				head1 = head1.next;
			}
			else {
				p.next = head2;
				p = head2;
				head2 = head2.next;
			}
				
		}
		
		if(head1 == null) 
			p.next = head2;
		if(head2 == null)
			p.next = head1;
		
		return head;
		
		
		
	}
	
	
	
}
