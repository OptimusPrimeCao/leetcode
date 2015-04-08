
public class AddTwoNums {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public static void main(String[] args) {
		

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    int carry = 0;
	    ListNode head = null;
	    ListNode p = null;
	    int val = 0;
	    
	    if(l1 == null && l2 == null) {
	    	return null;  	
	    }
	    if(l1 != null && l2 == null) {
	    	return l1;  
	    }
	    if(l1 == null && l2 != null) {
	    	return l2;
	    }


	    val = l1.val + l2.val;
	    head = new ListNode(val%10);
	    carry = val/10;
	    l1 = l1.next;
	    l2 = l2.next;

	    p = head;
	    while(l1 != null && l2 != null) {
	    	val = l1.val + l2.val + carry;
	    	ListNode q = new ListNode(val%10);
	    	p.next = q;
	    	p = q;
	    	carry = val/10;
	    	l1 = l1.next;
	    	l2 = l2.next;  	
	    }
	    while(l1 != null) {
	    	val = l1.val + carry;
	    	carry = val/10;
	    	ListNode q = new ListNode(val%10);
	    	p.next = q;
	    	p = q;
	    	l1 = l1.next;
	    }
	    while(l2 != null) {
	    	val = l2.val + carry;
	    	carry = val/10;
	    	ListNode q = new ListNode(val%10);
	    	p.next = q;
	    	p = q;
	    	l2 = l2.next;
	    }


	    if(carry == 1) {
	    	ListNode q = new ListNode(1);
	    	p.next = q;	
	    }

	    return head;
	}

}
