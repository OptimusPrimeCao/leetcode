
public class LinkedListCycle {

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
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
	      if(head == null) {
	    	  return false;
	      }
	      
	      ListNode fast = head;
	      ListNode slow = head;
	      while(fast.next != null && fast.next.next != null) {
	    	   slow = slow.next;
	    	   fast = fast.next.next;
	    	   if(fast == slow) {
	    		   return true;
	    	   }
	      }
	      return false;
    }
	public ListNode detectCycle(ListNode head) {
		 if(head == null) {
	    	  return null;
	      }
	      
	      ListNode fast = head;
	      ListNode slow = head;
	      while(fast.next != null && fast.next.next != null) {
	    	   slow = slow.next;
	    	   fast = fast.next.next;
	    	   if(fast == slow) {
	    		   ListNode temp = head;
	    		   while(temp != slow) {
	    			   slow = slow.next;
	    			   temp = temp.next;
	    		   }
	    		   return temp;
	    	   }
	      }
	      return null;
    }



}
