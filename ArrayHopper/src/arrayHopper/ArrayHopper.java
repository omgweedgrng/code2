package arrayHopper;

// Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
// A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). 
// Determine if you are able to reach the last index.

// Assumption: The given array is not null and has length of at least 1.

public class ArrayHopper {

	// DP solution 1
	// M[i]: can jump from index i to the end of array
	public boolean canJump(int[] array) {
		boolean[] canJump = new boolean[array.length];
		canJump[array.length - 1] = true;
		for (int i = array.length - 2; i >= 0; i--) {
			if (i + array[i] >= array.length - 1) {
				canJump[i] = true;
			} else {
				for (int j = 1; j <= array[i]; j++) {
					if (canJump[i + j]) {
						// why do we not need to do out of bound check?
						canJump[i] = true;
						break;
					}
				}
			}
		}
		return canJump[0];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// DP solution 2
	// M[i]: from index 0, can jump to index i
	public boolean canJump2(int[] array) {
		boolean[] canJump = new boolean[array.length];
		canJump[0] = true;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (canJump[j] && j + array[j] >= i) {
					canJump[i] = true;
					break;
				}
			}
		}
		return canJump[canJump.length - 1];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// Solution 3: greedy
	public boolean canJump3(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = max < i ? max : Math.max(max, i + nums[i]);
		}
		return max >= nums.length - 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

}
