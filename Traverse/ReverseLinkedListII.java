package Traverse;


public class ReverseLinkedListII {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || n<=m)
			return head;
		ListNode p = head;
		ListNode q ;
		int k = 1;
		if(m == 1) {
			q = head;
			head = null;              //作为标记
		}
		else {
			for(k=1; k<m-1; k++)
				p = p.next;
			q = p.next;             //p为第m-1个
		}
		
		//逆转从q开始的n-m+1个
		ListNode newHead = q;
		ListNode r = q.next;
		k = 1;
		while(k <= n-m) {                    // 循环n-m次
			q.next = r.next;
			r.next = newHead;
			newHead = r;
			r = q.next;
			k++;
			
		}
		
		if(head == null)
			return newHead;
		else 
			p.next = newHead;
		
		return head;
		
	}
}
