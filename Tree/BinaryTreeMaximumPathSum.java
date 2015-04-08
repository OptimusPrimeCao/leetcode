package Tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinaryTreeMaximumPathSum {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


//	public int maxPathSum(TreeNode root) {
//		Set<TreeNode> rootIsTerminal = new HashSet<TreeNode>();
//		rootIsTerminal.add(null);
//		return count(root, rootIsTerminal);
//		
//	}
//	public int count(TreeNode root, Set<TreeNode> rootIsTerminal) {
//		if(root == null)
//			return 0;
//
//		int leftSum = maxPathSum(root.left);
//		int rightSum = maxPathSum(root.right);
//		if(!rootIsTerminal.contains(root.left) && !rootIsTerminal.contains(root.right))
//			return Math.max(leftSum, rightSum);
//
//		if(rootIsTerminal.contains(root.left) && !rootIsTerminal.contains(root.right)) {
//			if(root.val >= 0)
//				leftSum = leftSum + root.val;
//
//			if(leftSum >= rightSum) {
//				if(root.val >= 0)
//					rootIsTerminal.add(root);
//				return leftSum;
//			}
//			else 
//				return rightSum;
//		}
//		if(!rootIsTerminal.contains(root.left)&& rootIsTerminal.contains(root.right)) {
//			if(root.val >= 0)
//				rightSum = rightSum + root.val;
//			
//			if(rightSum >= leftSum) {
//				if(root.val >= 0)
//					rootIsTerminal.add(root);
//				return rightSum;
//			}
//			else 
//				return leftSum;
//		}
//		
//		else {
//			int[] testArr = new int[5];
//			testArr[0] = rightSum + leftSum + root.val;
//			testArr[1] = rightSum + root.val;
//			testArr[2] = leftSum + root.val;
//			testArr[3] = rightSum;
//			testArr[4] = leftSum;
//			
//			Arrays.sort(testArr);
//			int max = testArr[4];
//			if(max==(rightSum + root.val) || max==(leftSum + root.val))
//				rootIsTerminal.add(root);
//			
//			return max;
	//			
	//		}


	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxSumWithRootIsTerMinal(root);
		return maxSum;
		
		
	}
	
	int maxSum;
	public int maxSumWithRootIsTerMinal(TreeNode root) {
		if(root == null)
			return 0;
		int leftSum = maxSumWithRootIsTerMinal(root.left);
		int rightSum = maxSumWithRootIsTerMinal(root.right);
		int value = root.val;
		if(leftSum > 0)
			value += leftSum;
		if(rightSum > 0)
			value += rightSum;	
		if(value > maxSum)
			maxSum = value;	
		return Math.max(root.val, Math.max(root.val+leftSum, root.val+rightSum));
	}

}

