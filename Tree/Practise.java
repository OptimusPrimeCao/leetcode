package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.TraverseTree.TreeNode;



public class Practise {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> ss = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		
		ss.push(root);
		while(!ss.isEmpty()) {
			root = ss.pop();
			result.add(root.val);
			if(root.right != null)
				ss.push(root.right);
			
			if(root.left != null)
				ss.push(root.left);
		}
		
		return result;
		
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> ss = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		TreeNode lastVisited = root;               //置为 null根节点会错误，若置为null判断条件应改为
											//(pre!=NULL)&&(cur->left==pre||cur->right==pre))
		if(root == null)
			return result;
		 
		ss.push(root);
		while(!ss.isEmpty()) {
			root = ss.peek();
			if((root.left == null && root.right == null) 
					|| (root.left == lastVisited) || (root.right == lastVisited)){
				result.add(root.val);
				ss.pop();
				lastVisited = root;
			}
			else {
				if(root.right != null)
					ss.push(root.right);
				if(root.left != null)
					ss.push(root.left);
			}
		}
		
		return result;
	}
	
	//root每次循环在变，前两个遍历方式都不用变
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Stack<TreeNode> ss = new Stack<TreeNode>();
		while(root != null || !ss.isEmpty()) {
			while(root != null) {
				ss.push(root);
				root = root.left;
				
			}
			root = ss.pop();
			nums.add(root.val);
			root = root.right;
		}
		return nums;
	}
	
	
	
	
	
	
	
}