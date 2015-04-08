package Tree;

public class RecoverySearchTree {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	TreeNode mistake1 = null;
	TreeNode mistake2 = null;
	TreeNode pre = null;
	public static void main(String[] args) {
		

	}
	public void recoverTree(TreeNode root) {
		traversal(root);
		int temp = mistake1.val;
		mistake1.val = mistake2.val;
		mistake2.val = temp;
	}
	public void traversal(TreeNode root) {
		if(root == null) 
			return;
		traversal(root.left);
		if(pre != null) {
			if(mistake1 == null  && root.val < pre.val)  {
				mistake1 = pre;
				mistake2 = root;             // 重要，不然相邻的交换mistake2置不进去
			}
			else if(root.val < pre.val)
				mistake2 = root;
		}
		pre = root;
		traversal(root.right);
	}

}
