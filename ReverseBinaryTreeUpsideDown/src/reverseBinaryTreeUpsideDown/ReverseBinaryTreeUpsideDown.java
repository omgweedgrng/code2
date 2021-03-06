package reverseBinaryTreeUpsideDown;

// Given a binary tree where all the right nodes are leaf nodes, 
// flip it upside down and turn it into a tree with left leaf nodes
// as the root.

public class ReverseBinaryTreeUpsideDown {

	// Solution 1: recursive solution
	public TreeNode reverse(TreeNode root) {
		// base case
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = reverse(root.left);
		// it is wrong to do
		// newRoot.left = root
		// newRoot.right = root.right
		root.left.left = root;
		root.left.right = root.right;
		// don't forget the following two lines
		root.left = null;
		root.right = null;
		return newRoot;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2: iterative solution
	public TreeNode reverse2(TreeNode root) {
		TreeNode cur = root;
		TreeNode next = null;
		TreeNode prev = null;
		TreeNode temp = null;
		TreeNode right = null;
		while (cur != null) {
			next = cur.left;
			cur.left = prev;
			right = cur.right;
			cur.right = temp;
			prev = cur;
			cur = next;
			temp = right;
		}
		return prev;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
