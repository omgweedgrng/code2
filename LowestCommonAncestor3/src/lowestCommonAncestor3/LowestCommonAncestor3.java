package lowestCommonAncestor3;

// Given two nodes in a binary tree, find their lowest common ancestor.
// Return null If any of the nodes is not in the tree.

// Assumptions:
// 1. There is no parent pointer for the nodes in the binary tree
// 2. The given two nodes are not guaranteed to be in the binary tree

public class LowestCommonAncestor3 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		if (find(root, one) && find(root, two)) {
			return LCA(root, one, two);
		}
		return null;
	}

	private boolean find(TreeNode root, TreeNode node) {
		// base case
		if (root == null || node == null) {
			return false;
		}
		if (root == node) {
			return true;
		}
		// recursive rule
		if (find(root.left, node)) {
			return true;
		}
		if (find(root.right, node)) {
			return true;
		}
		return false;
	}

	public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode left = LCA(root.left, one, two);
		TreeNode right = LCA(root.right, one, two);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	// Time complexity is O(n).
	// Space complexity is O(n) because of call-stack, if the binary tree is
	// highly unbalanced.

	public static void main(String[] args) {
		LowestCommonAncestor3 lowestCommonAncestor3 = new LowestCommonAncestor3();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(9);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(14);
		System.out.println(lowestCommonAncestor3.lowestCommonAncestor(root, root.left.left, root.right.right).key);
	}

}
