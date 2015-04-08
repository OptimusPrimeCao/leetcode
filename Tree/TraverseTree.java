package Tree;
import java.util.*;

import Tree.Practise.TreeNode;


public class TraverseTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<TreeNode> ss = new Stack<TreeNode>();
		System.out.println(ss.empty());

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
	public ArrayList<Integer> postorderTraversal(TreeNode root) {	       
		ArrayList<Integer> nums = new ArrayList<Integer>();
		TreeNode lastVisited = null;
		Stack<TreeNode> ss = new Stack<TreeNode>();
		if(root == null) {
			return nums;
		}
		
		while(!ss.isEmpty() || root != null) {
			while(root != null) {
				ss.push(root);
				root = root.left;
			}
			root = ss.peek();               
			if(root.right == null || root.right == lastVisited) {
				nums.add(root.val);
				lastVisited = ss.pop();
				root = null;     
			}
			else
				root = root.right;			
		}		
		return nums;
	}  
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
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

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> myQueue = new LinkedList<TreeNode>(); 
		TreeNode temp;
		//Stack<Integer> ss = new Stack<Integer>();
		boolean reverse = false;
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
			return nums;
		}
		myQueue.offer(root);
		myQueue.offer(null);
		while(!myQueue.isEmpty()) {
			temp = myQueue.poll();
			if(temp == null) {	      		
				if(reverse) {
					ArrayList<Integer> temAl = new ArrayList<Integer>();
					for(int j=al.size()-1;j>=0; j--) {
						temAl.add(al.get(j));

					}
					reverse = false;
					nums.add(temAl);
				}
				else {
					reverse = true;
					nums.add(al);
				}

				al = new ArrayList<Integer>();
				if(!myQueue.isEmpty()) 
					myQueue.offer(null);

			}
			else {
				al.add(temp.val);
				if(temp.left != null)   myQueue.offer(temp.left);
				if(temp.right != null)  myQueue.offer(temp.right);
			}
		}

		return nums;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
