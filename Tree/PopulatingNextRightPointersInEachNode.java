package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		queue.offer(null);
		TreeLinkNode pre = null;
		while(!queue.isEmpty()) {
			TreeLinkNode p = queue.poll();
			if(p != null) {
				if(pre != null) {
					pre.next = p;
					pre = p;
				}
				else
					pre = p;
				if(p.left != null)
					queue.offer(p.left);
				if(p.right != null)
					queue.offer(p.right);
			}
			else {
				if(!queue.isEmpty())
					queue.offer(null);
				pre.next = p;
				pre = null;
			}

		}
	}
}
