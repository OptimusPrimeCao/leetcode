package Sorting;
/*
 * 1.两步法
 * 2.归并链表
 * 
 * 
 * 
 * */
public class SortList {

	/**
	 * @param args
	 */
	
	class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
		  }
		  }
	public static void main(String[] args) {
		

	}
	 public ListNode sortList(ListNode head) {
		  ListNode p,q,r;
		  if(head == null || head.next == null) 
			  return head;
		  
		  p = head;
		  q = head;
		  while(q.next != null && q.next.next != null) {
			  q = q.next.next;
			  p = p.next;
		  }
		  r = p.next;
		  p.next = null;
		  return merge(sortList(head), sortList(r));
			  
			  
	        
	  }
	 
	 private ListNode merge(ListNode h1, ListNode h2) {
		 ListNode head;
		 ListNode p;
		 if(h1.val <= h2.val) {
			 head = h1;
			 h1 = h1.next;
		 }
		 else {
			 head = h2;
			 h2 = h2.next;
		 }
		 p = head;
		 while(h1 != null && h2 != null) {
			 if(h1.val <= h2.val) {
				 p.next = h1;
				 p = h1;
				 h1 = h1.next;
			 }
			 else {
				 p.next = h2;
			     p = h2;
			     h2 = h2.next;
		     }	 
		 }
		 if(h1 != null) {
			 p.next = h1;
		 }
		 if(h2 != null) {
			 p.next = h2;
		 }
		 
		return head; 
	}

}
