package Tree;

import java.util.Stack;

public class BinarySearchTreeIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	Stack<TreeNode> ss;
	
	public BinarySearchTreeIterator(TreeNode root) {
		ss = new Stack<TreeNode>();
		while(root != null) {
			ss.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !ss.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode curNode = null;
		if(hasNext()) {
			curNode = ss.pop();
			int rtv = curNode.val;
			curNode = curNode.right;
			while(curNode != null) {
				ss.push(curNode);
				curNode = curNode.left;
			}
			return rtv;
		}
		else 
			return -1;
	}
}	
