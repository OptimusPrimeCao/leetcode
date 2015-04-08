package Traverse;



public class ReverseNodesInkGroup {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode p = head;
		ListNode q = head;
		ListNode pre = null;
		while(p != null) {
			//count q
			int n = 1;
			while(n<k && q!=null) {
				q = q.next;
				n++;
			}
			if(q == null)
				return head;
			else {
				if(pre != null)
					pre.next = q;
				else
					head = q;
				
				ListNode temp = q.next;
				q.next = null;
				reverse(p);
				p.next = temp;
				
				pre = p;
				p = temp;
				q = p;
			}	
		}
		return head;
		
	}
	
	public static ListNode reverse(ListNode head) {
		ListNode newHead = head;
		ListNode p = head.next;
		while(p != null) {
			head.next = p.next;
			p.next = newHead;
			newHead = p;
			p = head.next ;
		}
		head.next = null;
		return newHead;	
	}
	
	public static void main(String[] args) {
		ListNode p = new ReverseNodesInkGroup.ListNode(1);
		ListNode q = new ReverseNodesInkGroup.ListNode(2);
		ListNode r = new ReverseNodesInkGroup.ListNode(3);
		p.next = q;
		q.next = r;
		r.next = null;
		ListNode h = reverseKGroup(p,3);
		System.out.println(h.val);
		System.out.println(h.next.val);
		System.out.println(h.next.next.val);
		System.out.println(h.next.next.next.val);
		System.out.println(h.next.next.next.next.val);
	}
	
}
