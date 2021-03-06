package twoSumAllPairs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all pairs of elements in a given array that sum to the given target number. 
// Return all the distinct pairs of values.

public class TwoSumAllPairs2 {

	// Solution 1
	public List<List<Integer>> allPairs(int[] array, int target) {
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (left > 0 && array[left] == array[left - 1]) {
				left++;
				continue;
			}
			if (array[left] + array[right] == target) {
				result.add(Arrays.asList(array[left++], array[right--]));
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n^2) in the worst case, because Arrays.sort() uses
	// Quick Sort for primitive types.
	// Space complexity is O(n) in the worst case, because of call-stack.

	// Solution 2
	public List<List<Integer>> allPairs2(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : array) {
			Integer count = map.get(num);
			if (num * 2 == target && count != null && count == 1) {
				result.add(Arrays.asList(num, num));
			} else if (map.containsKey(target - num) && count == null) {
				result.add(Arrays.asList(num, target - num));
			}
			if (count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
