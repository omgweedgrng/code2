package medianTracker;

import java.util.Collections;
import java.util.PriorityQueue;

// Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
// You will have to implement the following two methods for the class
// 1. read(int value): read one value from the flow 
// 2. median(): return the median at any time, return null if there is no value read so far

public class MedianTracker {

	private PriorityQueue<Integer> largerHalf; // min heap
	private PriorityQueue<Integer> smallerHalf; // max heap

	public MedianTracker() {
		this.largerHalf = new PriorityQueue<>();
		this.smallerHalf = new PriorityQueue<>(11, Collections.reverseOrder());
	}

	// maintain smallerHalf.size() == largerHalf.size(), when total number of
	// integers is even, and smallerHalf.size() = largerHalf.size() + 1, when
	// total number of integers is odd
	public void read(int value) {
		if (smallerHalf.size() == 0 || value < smallerHalf.peek()) {
			smallerHalf.offer(value);
		} else {
			largerHalf.offer(value);
		}
		if (smallerHalf.size() - largerHalf.size() == 2) {
			largerHalf.offer(smallerHalf.poll());
		} else if (largerHalf.size() - smallerHalf.size() == 1) {
			smallerHalf.offer(largerHalf.poll());
		}
	}

	public Double median() {
		int n = smallerHalf.size() + largerHalf.size();
		if (n == 0) {
			return null;
		} else if (n % 2 == 1) {
			return (double) smallerHalf.peek();
		} else {
			return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
		}
	}
}
