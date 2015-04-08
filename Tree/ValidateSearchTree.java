package Tree;

public class ValidateSearchTree {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; left = null; right = null; }
        }
	 public static void main(String[] args) {
		 new ValidateSearchTree().isValidBST(null);
	 }
	 public boolean isValidBST(TreeNode root) {
		 TreeNode p = null;
		 TreeNode q = null;
		 if(root == null) {
			 return true;
		 }
		 if(isValidBST(root.left) && isValidBST(root.right)) {
			 if(root.right != null) {
				 p = root.right;
				 while(p.left != null) {
					 p = p.left;
				 }
			 }
			 if(root.left != null) {
				 q = root.left;
				 while(q.right != null) {
					 q = q.right;
				 }
			 }
			 if(p == null && q == null) 
				return true;
			 if(p != null && q == null && root.val < p.val)
				 return true;
			 if(p == null && q != null && root.val > q.val)
				 return true;
			 if(p != null && q != null && root.val > q.val && root.val < p.val) 
				 return true;
		
		 }
		 return false;
	        
	   }
}
