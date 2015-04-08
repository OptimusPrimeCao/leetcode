package Tree;

public class MaxDepthOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	}
    public int maxDepth(TreeNode root) {
    	  if(null == root) 
    		  return 0;
    	  else {
    		  int lm = maxDepth(root.left);
    		  int lr = maxDepth(root.right);
    		  if(lm < lr) 
    			  return lr + 1;
    		  else
    			  return lm + 1;
    	  
    	  }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }