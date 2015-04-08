import java.util.*;
public class UniqueBinarySearchTree {

	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; left = null; right = null; }
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	      
	  }
	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTree().generateTrees(3));

	}
	public int numTrees(int n) {
		int sum = 0;
        if(0 == n) {
        	return 0;
        }
        if(1 == n) {
        	return 1;
        }
        for(int i=1; i<=n; i++) {
        	if(i-1 > 0 && n-i > 0) {
        		sum = sum + numTrees(i-1) * numTrees(n-i);
        	}
        	else {
        		if(n == i) {
        			sum = sum + numTrees(i-1);
        		}
        		else {
        			sum = sum + numTrees(n-i);
        		}
        	}
        	
        }
        return sum;
    }
	
	
	public ArrayList<TreeNode> generateTrees(int n) {
		if(0 == n) {
			TreeNode temp = null;
			ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
			trees.add(temp);
			return trees;
		}
		return getTrees(1, n);
    }
	public  ArrayList<TreeNode> getTrees(int low, int high) {
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		if(low == high) {
			trees.add(new TreeNode(low));
			return trees;
		}
        for(int i=low; i<=high; i++) {
        	if(i-low > 0 && high-i > 0) {
        		ArrayList<TreeNode> leftTrees = getTrees(low,i-1);
        		ArrayList<TreeNode> rightTrees = getTrees(i+1,high);
        		for(int j=0;j<leftTrees.size();j++) {
        			for(int k=0;k<rightTrees.size();k++) {
        				TreeNode root = new TreeNode(i);
        				root.left = leftTrees.get(j);
        				root.right = rightTrees.get(k);
        				trees.add(root);
        			}
        		}
        	}
        	else {
        		if(high == i) {    //½öÓÐ×ó
        			ArrayList<TreeNode> leftTrees = getTrees(low,i-1);
        			for(int j=0;j<leftTrees.size();j++) {
        				TreeNode root = new TreeNode(i);
        				root.left = leftTrees.get(j);
        				trees.add(root);
        			}
        		}
        		else {
        			ArrayList<TreeNode> rightTrees = getTrees(i+1,high);
        			for(int k=0;k<rightTrees.size();k++) {
        				TreeNode root = new TreeNode(i);
        				root.right = rightTrees.get(k);
        				trees.add(root);
        			}
        		}
        	}
        }
        return trees;
	}

}
