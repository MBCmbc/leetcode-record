package NiuKe.NC03;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
链表中环的入口节点，同leetcode P142
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head == null) return null;

		ListNode slow = head;
		ListNode fast = head;

		while(fast != null){
			if(fast.next == null || fast.next.next == null) return null;
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) break;
		}

		fast = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}
}
