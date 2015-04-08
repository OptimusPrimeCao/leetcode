package Tree;
public class SumRootToLeaf {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public static void main(String[] args) {
		

	}
    public int sumNumbers(TreeNode root) {
    	 
    	 return getSum(root, 0);
        
    }
    public int getSum(TreeNode root, int legacy) {
    	 if(root !=null) {
	    	  if(root.left == null && root.right == null) {
	    		  return legacy * 10 + root.val;
	    	  }
	    	  if(root.left != null && root.right != null) {
	    		  return getSum(root.left, legacy*10 + root.val) + getSum(root.right, legacy*10 + root.val);
	    	  }
	    	  if(root.left == null && root.right != null) {
	    		  return getSum(root.right, legacy*10 + root.val);
	    	  }
	    	  if(root.left != null && root.right == null) {
	    		  return getSum(root.left, legacy*10 + root.val);
	          }
    	 }
    	return 0;
    }
}
