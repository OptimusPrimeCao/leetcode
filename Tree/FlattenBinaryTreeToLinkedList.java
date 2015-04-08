package Tree;

import Tree.ConstructTree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	
	public void flatten(TreeNode root) {
		if(root == null)
			return;
		flatten(root.left);
		
		TreeNode temp = root.right;
		
		if(root.left != null) {
			TreeNode p = root.left;
			while(p.right != null)
				p = p.right;
			
			p.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		flatten(temp);
		return;
	}
	
	TreeNode pre = null;
	public void flatten2(TreeNode root) {
		if(root == null)
			return;
		if(pre != null) {
			pre.right = root;
			pre.left = null;
		}
		pre = root;
		TreeNode temp = root.right;
		flatten2(root.left);
		flatten2(temp);
		
	}
	
}		
