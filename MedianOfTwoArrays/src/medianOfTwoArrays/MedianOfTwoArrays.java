package medianOfTwoArrays;

import java.util.Arrays;

// LeetCode #4

// Given two sorted arrays of integers, find the median value.
// Assumptions: The two given arrays are not null and at least one of them is not empty.

public class MedianOfTwoArrays {

	// Solution 1: Use heap
	// Time Complexity is O(m+n) to heapify, O((m+n) * log(m+n)) to find median.
	// Space Complexity is O(m+n).

	// Solution 2
	public double median(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		if ((a.length + b.length) % 2 == 1) {
			return kth(a, 0, b, 0, (a.length + b.length) / 2 + 1);
		} else {
			return (double) (kth(a, 0, b, 0, (a.length + b.length) / 2)
					+ kth(a, 0, b, 0, (a.length + b.length) / 2 + 1)) / 2;
		}
	}

	private int kth(int[] a, int aLeft, int[] b, int bLeft, int k) {
		// base case
		if (aLeft >= a.length) {
			return b[bLeft + k - 1];
		}
		if (bLeft >= b.length) {
			return a[aLeft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aLeft], b[bLeft]);
		}
		// compare the k/2-th element in subarray of a, and k/2-th element in
		// subarray of b
		int aMid = aLeft + k / 2 - 1;
		int bMid = bLeft + k / 2 - 1;
		int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
		int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
		if (aVal <= bVal) {
			return kth(a, aMid + 1, b, bLeft, k - k / 2);
		} else {
			return kth(a, aLeft, b, bMid + 1, k - k / 2);
		}
	}

	// Arrays.sort() uses Quick Sort for primitive types.
	// Time complexity is O(m*log(m) + n*log(n)).
	// Space complexity is O(1).

	// Solution 3: Put two arrays together, and use Quick Select.
	// Time Complexity is worst case O((m+n)^2), and average case O(m+n).
	// Space Complexity is worst case O(m+n), and average case O(log(m+n)).

	// Median of Medians algorithm can reduce Time Complexity to worst case
	// O(m+n), and can reduce Space Complexity to worst case O(log(m+n)).
}
