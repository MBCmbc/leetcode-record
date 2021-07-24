package NiuKe.NC51;

import LinkedList.ListNode;

import java.util.ArrayList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
合并k个排序链表，分治法。同leetcode P 23
*/
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists.size() == 0) return null;
		return merge(lists, 0, lists.size() - 1);
	}

	public ListNode merge(ArrayList<ListNode> lists, int lo, int hi){
		if(lo == hi) return lists.get(lo);

		int mid = lo + (hi - lo) / 2;
		ListNode l1 = merge(lists, lo, mid);
		ListNode l2 = merge(lists, mid+1, hi);
		return merge2Lists(l1, l2);
	}

	public ListNode merge2Lists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		if(l1.val < l2.val){
			l1.next = merge2Lists(l1.next, l2);
			return l1;
		} else{
			l2.next = merge2Lists(l1, l2.next);
			return l2;
		}
	}
}
