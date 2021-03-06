package reverseLinkedListInPairs;

// LeetCode #24 (Swap Nodes in Pairs).

// Reverse pairs of elements in a singly-linked list.

public class ReverseLinkedListInPairs {

	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// head != null && head.next != null
		ListNode next = head.next;
		ListNode newHead = reverseInPairs(next.next);
		head.next = newHead;
		next.next = head;
		return next;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack.

	// iterative solution
	public ListNode reverseInPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			ListNode first = cur.next;
			ListNode second = first.next;
			cur.next = second;
			first.next = second.next;
			second.next = first;
			cur = cur.next.next;
		}
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

