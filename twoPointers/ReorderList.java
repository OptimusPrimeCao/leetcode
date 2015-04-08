package twoPointers;

import Sorting.InsertionSortList2;
import Sorting.InsertionSortList2.ListNode;

public class ReorderList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	//递归方法超时了
	public static void reorderList2(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
			return ;
		
		ListNode p = head;
		ListNode pre = null;
		while(p.next != null) {
			pre = p ;
			p = p.next;	
		}
		
		
		p.next = head.next;
		head.next = p;
		pre.next = null;
		reorderList2(p.next);

	}
	
	
	public void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return ;
		
		
		ListNode p = head;
		ListNode q = head;
		
		while(q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
		}
		
		ListNode head2 = reverse(p.next);
		p.next = null;
		merge(head, head2);
		return ;
		

	}
	

	public static void merge(ListNode h, ListNode h2) {
		ListNode p = h;
		ListNode q = h2;
		while(q != null) {
			ListNode temp1 = p.next;
			ListNode temp2 = q.next;
			p.next = q;
			p = temp1;
			q.next = temp1;
			q = temp2;
		}


	}


	public static ListNode reverse(ListNode head) {
		ListNode p = head.next;
		ListNode newHead = head;
		while(p != null) {
			head.next = p.next;
			p.next = newHead;
			newHead = p;
			p = head.next;
		}
		return newHead;
	}


	public static void main(String[] args) {
		InsertionSortList2 ss = new InsertionSortList2();
		
		ListNode p = new ReorderList.ListNode(4);
		ListNode q = new ReorderList.ListNode(2);
		ListNode r = new ReorderList.ListNode(1);
		ListNode s = new ReorderList.ListNode(3);
		p.next = q;
		q.next = r;
		r.next = s;
		
		ListNode h = reverse(p);
		System.out.println(h.val);
		System.out.println(h.next.val);
		System.out.println(h.next.next.val);
		System.out.println(h.next.next.next.val);
		System.out.println(h.next.next.next.next.val);
		
	}
	
	
}
