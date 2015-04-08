package Tree;

import Tree.Solution.TreeNode;

public class BalancedBinaryTree {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isBalanced(TreeNode root) {
        if(root != null) {
       	if(isBalanced(root.left) && isBalanced(root.right)) {
       		int leftHeight = getHeight(root.left);
       		int rightHeight = getHeight(root.right);
       		int heightDif = leftHeight> rightHeight ? leftHeight - rightHeight : rightHeight - leftHeight;
       		if(heightDif <= 1) {
       			return true;
       		}
       	}
       	return false;
       }
       return true;
   }
   public int getHeight(TreeNode root) {
   	if(root != null) 
   		return getHeight(root.left)>getHeight(root.right)? getHeight(root.left) + 1:getHeight(root.right) + 1; 
   	else 
   		return 0;
   }

}
