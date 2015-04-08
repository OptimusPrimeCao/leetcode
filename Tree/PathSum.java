package Tree;
import java.util.*;

import Tree.Solution.TreeNode;
public class PathSum {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root != null) {
    		if(root.left != null && root.right == null) 
    			return hasPathSum(root.left, sum-root.val);
    		if(root.left == null && root.right != null) 
    			return hasPathSum(root.right, sum-root.val);
    		if(root.left != null && root.right != null) 
    			return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    		if(root.left == null && root.right == null)
    			return sum == root.val;
    	}
    	return false;
    }

    
    
    
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
         ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
         ArrayList<Integer> a = new ArrayList<Integer>();
         return judge2(root, sum, 0, a, lists);
	}
	
	public List<List<Integer>> judge2(TreeNode root, int sum, int legacy, ArrayList<Integer> a, ArrayList<List<Integer>> lists) {
		if(root != null) {
			if(root.left != null && root.right == null) {
				a.add(root.val);
				judge2(root.left, sum, legacy + root.val, a, lists);
				a.remove(a.size()-1);
			}
				
			if(root.left == null && root.right != null) {
				a.add(root.val);
				judge2(root.right, sum, legacy + root.val, a, lists);
				a.remove(a.size()-1);
			}
				
			if(root.left != null && root.right != null) {
				a.add(root.val);
				judge2(root.left, sum, legacy + root.val, a, lists);
				judge2(root.right, sum, legacy + root.val, a, lists);
				a.remove(a.size()-1);
			}
	           
	        if(root.left == null && root.right == null)
	        	if(sum == legacy + root.val) {
	        		ArrayList<Integer> b = new ArrayList<Integer>(a);
	        		b.add(root.val);
	        		lists.add(b);
	        	}
	        		
		}
		lists.add(a);
		return lists;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	 

}
