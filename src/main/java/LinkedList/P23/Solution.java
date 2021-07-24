package LinkedList.P23;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
思路，分治合并。用递归的方式，两两合并，像一棵二叉树一样，从底向上一层一层的合并，最终返回一个合并后的链表。

时间复杂度：
空间复杂度：
 */
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
		return merge(lists, 0, lists.length - 1);
	}

	//递归函数，递归地合并链表数组中的两个。
	public ListNode merge(ListNode[] lists, int lo, int hi){
		if(lo == hi) return lists[lo];

		int mid = lo + (hi - lo) / 2;           //一层一层的分为两部分进行合并
		ListNode l1 = merge(lists, lo, mid);
		ListNode l2 = merge(lists, mid+1, hi);
		return merge2Lists(l1, l2);             //左子节点和右子节点合并。
	}

	//合并两个单链表的函数。
	public ListNode merge2Lists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		p.next = l1==null ? l2 : l1;
		return dummy.next;
	}
}
