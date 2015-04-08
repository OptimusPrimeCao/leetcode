package twoPointers;

public class IntersectionOfTwoLinkedLists {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		int lenA = 1;
		int lenB = 1;
		ListNode pA = headA;
		ListNode pB = headB;
		while(pA.next != null) {
			lenA ++ ;
			pA = pA.next;
		}
		while(pB.next != null) {
			lenB ++ ;
			pB = pB.next;
		}
		
		if(pA != pB)
			return null;
		
		 pA = headA;
		 pB = headB;
		
		if(lenA > lenB) {
			int dis = lenA - lenB;
			for(int i=1;i<=dis;i++) 
				pA = pA.next;
		}
		else {
			int dis = lenB - lenA;
			for(int i=1;i<=dis;i++) 
				pB = pB.next;
		}
		
		while(pA != pB) {
			pA = pA.next;
			pB = pB.next;
		}
		
		return pA;
		
		
	}
}	
