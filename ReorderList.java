


public class ReorderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		ListNode p;
		new ReorderList().reorderList(a);
		p = a;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
		

	}
	
    public void reorderList(ListNode head) {
          ListNode p = head;
          ListNode q = head;
          
          if(head == null || head.next == null) {
        	  return;
          }
          
          while(q.next != null && q.next.next != null) {
        	  q = q.next.next;
        	  p = p.next;
          }
          
          ListNode h1 = head;
          ListNode h2 = reverse(p.next);
          p.next = null;
          ListNode temp1;
          ListNode temp2;
          
          while(h2 != null) {
        	  temp1 = h1.next;
        	  temp2 = h2.next;
        	  h1.next = h2;
        	  h2.next = temp1;
        	  h1 = temp1;
        	  h2 = temp2;
          }
         
    }
    private ListNode reverse(ListNode head) {
    	 if(head == null) {
    	     return head;
    	 }
    	 
		 ListNode p = head.next;
    	 ListNode q = head;
    	 while(p != null) {
    		 head.next = p.next;
    		 p.next = q;
    		 q = p;
    		 p = head.next;
    	 }
    	 
    	 return q;
    	 
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
	  }
}
