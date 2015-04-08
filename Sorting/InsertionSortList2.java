package Sorting;


public class InsertionSortList2 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		
		ListNode p = head.next;
		ListNode pre = head;
		
		ListNode testNode = head;
		
		while(p != null) {
			if(p.val < head.val) {
				pre.next = p.next;
				p.next = head;
				head = p;
				p = pre.next;
				testNode = head;
				continue;
			}
			
			while(testNode.next.val < p.val)
				testNode = testNode.next;
			
			if(testNode.next == p) {
				pre = p;
				p = p.next;

			}

			else {
				pre.next = p.next;
				p.next = testNode.next;
				testNode.next = p;
				p = pre.next;
			}
			testNode = head;
			
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		InsertionSortList2 ss = new InsertionSortList2();
		
		ListNode p = new InsertionSortList2.ListNode(4);
		ListNode q = new InsertionSortList2.ListNode(2);
		ListNode r = new InsertionSortList2.ListNode(1);
		ListNode s = new InsertionSortList2.ListNode(3);
		p.next = q;
		q.next = r;
		r.next = s;
		
		ListNode h = insertionSortList(p);
		System.out.println(h.val);
		System.out.println(h.next.val);
		System.out.println(h.next.next.val);
		System.out.println(h.next.next.next.val);
		System.out.println(h.next.next.next.next.val);
		
	}
}
