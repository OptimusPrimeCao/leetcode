package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		queue.offer(root);
		queue.offer(null);

		TreeNode lastNodeInOneLevel = null;
		while(!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			if(curNode != null) {
				lastNodeInOneLevel = curNode;
				if(curNode.left != null)
					queue.offer(curNode.left);
				if(curNode.right != null)
					queue.offer(curNode.right);
			}
			else {
				result.add(lastNodeInOneLevel.val);
				if(!queue.isEmpty()) {
					queue.offer(null);
				}

			}
		}
		return result;

	}
}
