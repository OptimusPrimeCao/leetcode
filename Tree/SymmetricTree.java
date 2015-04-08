package Tree;

import java.util.Stack;


public class SymmetricTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}

	public boolean isSymmetric(TreeNode root) {
		    TreeNode oldRoot = copyTree(root);
            reverseTree(root);
            if(isSameTree(root, oldRoot)) {
            	return true;
            }
            else
            	return false;
	}
	public void reverseTree(TreeNode root) {
        if(root!= null) {
        	reverseTree(root.left);
        	reverseTree(root.right);
        	TreeNode tempNode = root.left;
        	root.left = root.right;
        	root.right = tempNode;   
        }
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p != null && q != null && p.val == q.val) 
			return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		if(p == null && q == null) 
			return true;
		return false;
	}
	public TreeNode copyTree(TreeNode root) {
		if(null == root) {
			return null;
	   }
	   else {
		   TreeNode newRoot = new TreeNode(root.val);
		   newRoot.left = copyTree(root.left);
		   newRoot.right = copyTree(root.right);
		   return newRoot;
        }
   }
	
	
	public boolean isSymmetric2(TreeNode root) {
		Stack<TreeNode> leftStack = new Stack<TreeNode>();
		Stack<TreeNode> rightStack = new Stack<TreeNode>();
		if(root == null)
			return true;
		
		leftStack.push(root.left);
		rightStack.push(root.right);
		while(!leftStack.isEmpty()) {
			TreeNode leftNode = leftStack.pop();
			TreeNode rightNode = rightStack.pop();
			if(leftNode == null && rightNode == null)
				continue;
			if((leftNode != null && rightNode != null) && (leftNode.val == rightNode.val)) {
				leftStack.push(leftNode.right);
				leftStack.push(leftNode.left);
				rightStack.push(rightNode.left);
				rightStack.push(rightNode.right);
				continue;
			}
			return false;
		}
		return true;
	}
	//			if(leftNode == null || rightNode == null)
	//				return false;
	
	//和isSameTree 完全一样
	public boolean isSymmetric3(TreeNode p, TreeNode q){
		 if(p != null && q != null && p.val == q.val) 
			 return isSymmetric3(p.left,q.right) && isSymmetric3(p.right,q.left);
		 if(p == null && q == null) 
			 return true;
		 return false;


	}





}

