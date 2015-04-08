package Tree;
public class ConstructTree {

	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree1(int[] preorder, int[] inorder) {
		if(preorder.length == 0) {
			return null;
		}
		return recursiveBuildTree(preorder, 0, inorder, 0, inorder.length-1);
    }
	public TreeNode recursiveBuildTree(int[] preorder, int rootIndex, int[] inorder, int low, int high) {
        if(low > high) {
        	return null;
        }
		int rootNO = preorder[rootIndex];
		TreeNode t = new TreeNode(rootNO);
		int i;
        for(i=low; i<=high;i++) {
        	if(rootNO == inorder[i]) {
        		break;
        	}
        }
        t.left = recursiveBuildTree(preorder, rootIndex+1, inorder, low, i-1);
        t.right = recursiveBuildTree(preorder, rootIndex+ i-low+1, inorder, i+1, high);
        return t;
    }
	public TreeNode buildTree2(int[] postorder, int[] inorder) {
		if(postorder.length == 0) {
			return null;
		}
		return recursiveBuildTree2(postorder, postorder.length-1, inorder, 0, inorder.length-1);
    }
	public TreeNode recursiveBuildTree2(int[] postorder, int rootIndex, int[] inorder, int low, int high) {
        if(low > high) {
        	return null;
        }
		int rootNO = postorder[rootIndex];
		TreeNode t = new TreeNode(rootNO);
		int i;
        for(i=low; i<=high;i++) {
        	if(rootNO == inorder[i]) {
        		break;
        	}
        }
        t.left = recursiveBuildTree2(postorder, rootIndex-(high-i)-1, inorder, low, i-1);
        t.right = recursiveBuildTree2(postorder, rootIndex-1, inorder, i+1, high);
        return t;
    }

}
