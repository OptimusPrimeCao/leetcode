package Tree;
public class MinimuDepthOfTree {

	public static void main(String[] args) {
		

	}
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int minDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        } 
        if(root.left == null) {
        	return minDepth(root.right) + 1;
        }
        if(root.right == null) {
        	return minDepth(root.left) + 1;
        }
        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);
        return lDepth<rDepth ? lDepth+1 : rDepth+1;
    }

}
