package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.ValidationEvent;

public class PathSumII {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = countPath(root, sum);
		if(paths != null)
			for(List<Integer> path : paths) {
				Collections.reverse(path);
			}
		else 
			paths = new ArrayList<List<Integer>>(); 
		return paths;
	}


	public List<List<Integer>> countPath(TreeNode root, int sum) {
		if(root == null)
			return null;

		if(root.left == null && root.right == null) {
			if(sum == root.val) {
				List<List<Integer>> result = new ArrayList<List<Integer>>();
				List<Integer> path = new ArrayList<Integer>();
				path.add(root.val);
				result.add(path);
				return result;
			}
			else 
				return null;
		}
		List<List<Integer>> leftPaths = null;
		List<List<Integer>> rightPaths = null;

		if(root.left != null) {
			leftPaths = countPath(root.left, sum-root.val);
			if(leftPaths != null)
				for(List<Integer> path : leftPaths) {
					path.add(root.val);
				}
		}
		if(root.right != null) {
			rightPaths = countPath(root.right, sum-root.val);
			if(rightPaths != null)
				for(List<Integer> path : rightPaths) {
					path.add(root.val);
				}
		}
		if(leftPaths == null ) 
			return rightPaths;
		if(rightPaths != null) {
			leftPaths.addAll(rightPaths);
		}
		//		if(root.left != null && root.right == null) 
		//			return leftPaths;
		return leftPaths;
	}

}
