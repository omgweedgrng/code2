package closestNumberInBinarySearchTree;

// In a binary search tree, find the node containing the closest number to the given target number.

// Assumption:
// 1. The given root is not null.
// 2. There are no duplicate keys in the binary search tree.

public class ClosestNumberInBinarySearchTree {

	// recursive solution
	public int closest(TreeNode root, int target) {
		// base case
		if (root.left == null && root.right == null || root.key == target) {
			return root.key;
		}
		// root.key != target && (root.left != null || root.right != null)
		if (root.key < target) {
			if (root.right == null) {
				return root.key;
			} else {
				int right = closest(root.right, target);
				return Math.abs(root.key - target) <= Math.abs(right - target) ? root.key : right;
			}
		}
		if (root.key > target) {
			if (root.left == null) {
				return root.key;
			} else {
				int left = closest(root.left, target);
				return Math.abs(root.key - target) <= Math.abs(left - target) ? root.key : left;

			}
		}
		// will never reach this point
		return Integer.MIN_VALUE;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(log(n)).

	// iterative solution
	public int closest2(TreeNode root, int target) {
		if (root.key == target || (root.left == null && root.right == null)) {
			return root.key;
		}
		int result = root.key;
		while (root != null) {
			if (root.key == target) {
				return root.key;
			} else {
				if (Math.abs(root.key - target) < Math.abs(result - target)) {
					result = root.key;
				}
				if (root.key < target) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}
		return result;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).

	public static void main(String[] args) {
		ClosestNumberInBinarySearchTree closestNumberInBinarySearchTree = new ClosestNumberInBinarySearchTree();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		System.out.println(closestNumberInBinarySearchTree.closest(root, 3));
	}

}
