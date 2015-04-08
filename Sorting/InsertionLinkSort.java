package Sorting;



public class InsertionLinkSort {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode insertionSortList(ListNode head) {
    	ListNode p,q,pre,temp;
    	if(head == null || head.next == null)
    		return head;
    	else {
	        p = head;
	        while(p.next != null) {
	        	q = head;
	        	pre = null;
	        	
	        	while(q != p.next) { 
	        		if(q.val > p.next.val) {
	        			temp = p.next;
	        			p.next = p.next.next;
	        			temp.next = q;
	        			if(null == pre) {	        				
	        				head = temp;        				
	        			}
	        			else {
	        				pre.next = temp;
		        			
	        			}
	        			
	        			break;
	        		}
	        	    pre = q;
	        	    q = q.next;
	        	}
	           if(q == p.next) {
	        	    p = p.next;
	           }
	        	
	        	
	        }
	        return head;	
    	}
    }

}
