package Tree;

public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Solution {
	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 boolean flag;
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p != null && q != null && p.val == q.val) 
			 return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		 if(p == null && q == null) 
			 return true;
		 return false;

	 }
 }