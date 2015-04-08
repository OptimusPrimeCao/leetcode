package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public List<TreeNode> generateTrees(int n) {
		return dfs(1,n);
	}
	public List<TreeNode> dfs(int start, int end) {
		List<TreeNode> roots = new ArrayList<TreeNode>();
		if(start > end) {
			roots.add(null);
			return roots;
		}
		for(int i=start;i<=end;i++) {
			List<TreeNode> leftTrees = dfs(start,i-1);
			List<TreeNode> rightTrees = dfs(i+1,end);
			for(TreeNode leftTree : leftTrees) {
				for(TreeNode rightTree : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					roots.add(root);
				}
			}
			
		}
		return roots;
	}
	
}
