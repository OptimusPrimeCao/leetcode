package BackTracking;

public class ConverSortedLisToBinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		ListNode p = head;
		ListNode q = head;
		ListNode pre = null;
		while(q.next != null && q.next.next !=null) {
			q = q.next.next;
			pre = p;
			p = p.next;
		}
		
		TreeNode root = new TreeNode(p.val);
		if(p != head) {
			pre.next = null;
			root.left = sortedListToBST(head);
		}
		else
			root.left = null;
		root.right = sortedListToBST(p.next);
		return root;
	}
}
